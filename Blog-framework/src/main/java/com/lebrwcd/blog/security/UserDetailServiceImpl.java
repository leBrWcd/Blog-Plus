package com.lebrwcd.blog.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lebrwcd.blog.entity.model.SysUser;
import com.lebrwcd.blog.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Description 1.自定义UserDetailsServiceImpl 实现 UserDetailsService，根据用户名去数据库查询
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/15
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUserName,username);
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        if (Objects.isNull(sysUser)) {
            throw new UsernameNotFoundException("用户名不正确");
        }
        // TODO 查询用户对应权限信息
        return new LoginUser(sysUser);
    }
}
