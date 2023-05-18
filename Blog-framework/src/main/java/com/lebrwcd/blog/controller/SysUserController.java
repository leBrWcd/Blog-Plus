package com.lebrwcd.blog.controller;


import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.entity.dto.LoginDTO;
import com.lebrwcd.blog.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginDTO loginDTO) {
        log.info("登录请求体参数:{}",loginDTO);
        return sysUserService.login(loginDTO);
    }

}

