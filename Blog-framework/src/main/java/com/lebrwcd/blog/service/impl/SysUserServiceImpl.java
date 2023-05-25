package com.lebrwcd.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.common.constant.RedisConstants;
import com.lebrwcd.blog.common.enums.HttpCodeEnum;
import com.lebrwcd.blog.common.security.LoginUser;
import com.lebrwcd.blog.common.utils.CopyBeanUtil;
import com.lebrwcd.blog.common.utils.JwtUtil;
import com.lebrwcd.blog.common.utils.RedisCache;
import com.lebrwcd.blog.entity.dto.LoginDTO;
import com.lebrwcd.blog.entity.model.SysUser;
import com.lebrwcd.blog.entity.vo.BlogUserLoginVo;
import com.lebrwcd.blog.entity.vo.UserInfoVo;
import com.lebrwcd.blog.mapper.SysUserMapper;
import com.lebrwcd.blog.service.SysUserService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.CharSequenceEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-05-14 21:45:01
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private RedisCache redisCache;

    @Override
    public ResponseResult login(SysUser user) {

        // 1.AuthenticationManager 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 判断是否认证通过
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("认证失败!");
        }
        // 认证通过,根据userid生成jwt
        LoginUser loginUser = (LoginUser)authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);

        // userid作为key，用户信息作为value存入redis
        redisCache.setCacheObject(RedisConstants.LOGIN_USER_PRE + userid,loginUser);

        // 封装返回信息
        UserInfoVo userInfoVo = CopyBeanUtil.copyBean(loginUser.getUser(), UserInfoVo.class);
        BlogUserLoginVo vo = new BlogUserLoginVo(jwt,userInfoVo);
        return new ResponseResult().ok(vo);

    }

    @Override
    public ResponseResult logout() {
        // 1.清理SecurityContextHolder中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser user = (LoginUser)authentication.getPrincipal();
        // 2.清理redis中缓存的用户信息
        redisCache.deleteObject("login:" + user.getUser().getId().toString());
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult register(SysUser user) {

        String userName = user.getUserName();
        String email = user.getEmail();

        // 1.判断唯一性
        Integer nameCount = lambdaQuery().eq(SysUser::getUserName, userName).count();
        Integer emailCount = lambdaQuery().eq(SysUser::getEmail, email).count();
        if (nameCount > 0 ) {
            return ResponseResult.errorResult(HttpCodeEnum.USERNAME_EXIST);
        }
        if (emailCount > 0) {
            return ResponseResult.errorResult(HttpCodeEnum.EMAIL_EXIST);
        }
        // 2.密码处理
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        // 3.注册处理
        int insert = baseMapper.insert(user);
        if (insert == 0) {
            return ResponseResult.errorResult(HttpCodeEnum.SYSTEM_ERROR);
        }
        return ResponseResult.okResult();
    }
}

