package com.lebrwcd.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.entity.dto.LoginDTO;
import com.lebrwcd.blog.entity.model.SysUser;


/**
 * 用户表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2023-05-14 21:45:01
 */
public interface SysUserService extends IService<SysUser> {

    ResponseResult login(LoginDTO loginDTO);
}

