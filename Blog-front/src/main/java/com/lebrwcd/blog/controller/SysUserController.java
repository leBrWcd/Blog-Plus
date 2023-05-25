package com.lebrwcd.blog.controller;


import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.entity.dto.LoginDTO;
import com.lebrwcd.blog.entity.model.SysUser;
import com.lebrwcd.blog.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2023-05-14 21:45:01
 */
@Slf4j
@RestController
public class SysUserController  {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody SysUser user) {
        log.info("登录请求体参数:{}",user);
        return sysUserService.login(user);
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping("/logout")
    public ResponseResult logout() {
        log.info("退出登录接口");
        return sysUserService.logout();
    }

    @PostMapping("/user/register")
    public ResponseResult register(@RequestBody SysUser user) {
        log.info("注册接口...");
        return sysUserService.register(user);
    }

}

