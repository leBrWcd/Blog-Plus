package com.lebrwcd.blog.handler.security;

import com.alibaba.fastjson.JSON;
import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.common.enums.HttpCodeEnum;
import com.lebrwcd.blog.common.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description 授权失败处理器
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/22
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        e.printStackTrace();

        ResponseResult result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
        WebUtils.renderString(response, JSON.toJSONString(result));

    }
}
