package com.lebrwcd.blog.handler.exec;

import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.common.enums.HttpCodeEnum;
import com.lebrwcd.blog.common.exec.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Description 全局异常处理器
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/22
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseResult globalException(GlobalException e) {
        log.info("发生了全局异常: {}",e.getMsg());
        return ResponseResult.errorResult(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult exception(Exception e) {
        log.info("发生异常信息 : {}",e.getMessage());
        return ResponseResult.errorResult(HttpCodeEnum.SYSTEM_ERROR.getCode(),e.getMessage());
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseResult insufficientAuthenticationException(InsufficientAuthenticationException e) {
        log.info("认证授权异常: {}",e.getMessage() );
        return ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN.getCode(),e.getMessage());
    }
}
