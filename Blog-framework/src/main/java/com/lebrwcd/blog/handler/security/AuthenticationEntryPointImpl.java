package com.lebrwcd.blog.handler.security;

import com.alibaba.fastjson.JSON;
import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.common.enums.HttpCodeEnum;
import com.lebrwcd.blog.common.utils.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description 认证失败异常处理
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/22
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        ResponseResult result = null;
        if (e instanceof BadCredentialsException) {
            result = ResponseResult.errorResult(HttpCodeEnum.LOGIN_ERROR.getCode(),"用户名或密码错误");
        } else if (e instanceof InsufficientAuthenticationException) {
            result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN.getCode(),"请先进行登录操作");
        } else {
            result = ResponseResult.errorResult(HttpCodeEnum.SYSTEM_ERROR.getCode(),"认证或授权失败");
        }
        WebUtils.renderString(response, JSON.toJSONString(result));

    }
}
