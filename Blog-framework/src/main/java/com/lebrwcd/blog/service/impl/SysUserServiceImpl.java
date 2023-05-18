package com.lebrwcd.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.constant.RedisConstants;
import com.lebrwcd.blog.security.LoginUser;
import com.lebrwcd.blog.utils.CopyBeanUtil;
import com.lebrwcd.blog.utils.JwtUtil;
import com.lebrwcd.blog.utils.RedisCache;
import com.lebrwcd.blog.entity.dto.LoginDTO;
import com.lebrwcd.blog.entity.model.SysUser;
import com.lebrwcd.blog.entity.vo.BlogUserLoginVo;
import com.lebrwcd.blog.entity.vo.UserInfoVo;
import com.lebrwcd.blog.mapper.SysUserMapper;
import com.lebrwcd.blog.service.SysUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    @Resource
    private RedisCache redisCache;

    @Override
    public ResponseResult login(LoginDTO loginDTO) {

        // 1.AuthenticationManager 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
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
}

