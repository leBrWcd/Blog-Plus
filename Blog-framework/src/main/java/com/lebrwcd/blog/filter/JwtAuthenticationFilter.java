package com.lebrwcd.blog.filter;

import com.alibaba.fastjson.JSON;
import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.common.constant.RedisConstants;
import com.lebrwcd.blog.common.enums.HttpCodeEnum;
import com.lebrwcd.blog.common.security.LoginUser;
import com.lebrwcd.blog.common.utils.JwtUtil;
import com.lebrwcd.blog.common.utils.RedisCache;
import com.lebrwcd.blog.common.utils.WebUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;

/**
 * Description Jwt过滤器
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/18
 */
@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1.获取token值
        String token = request.getHeader("token");
        String token1 = request.getHeader("Token");
        String token2 = request.getHeader("User-Token");
        log.info(token1 +"," + token2);
        log.info("token :{}",token);
        // 1.1判断是否有token，如果没有，表示该接口不需要登录操作,直接放行
        if (!StringUtils.hasText(token)) {
            log.info("请求地址:" + request.getRequestURI());
            filterChain.doFilter(request,response);
            return;
        }
        // 2.有token，解析token获取用户id
        Claims claims = null;
        try {
           claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            // token超时/非法
            ResponseResult result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(result));
            return;
        }
        // 2.2根据用户id从redis中获取用户信息
        String userId = claims.getSubject();
        // 2.3如果获取不到用户信息，表示登录过期，返回错误信息提示重新登录
        LoginUser user = redisCache.getCacheObject(RedisConstants.LOGIN_USER_PRE + userId);
        if (Objects.isNull(user)) {
            ResponseResult result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(result));
            return;
        }
        // 2.4获取到用户信息，存入SecurityHolder
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null,null);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request,response);

    }
}
