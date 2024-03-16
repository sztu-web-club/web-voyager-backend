package io.github.sztuwebclub.webvoyager.application.http;

import io.github.sztuwebclub.webvoyager.constant.JwtProperties;
import io.github.sztuwebclub.webvoyager.constant.enumerate.JwtClaimsEnum;
import io.github.sztuwebclub.webvoyager.constant.utils.ContextUtil;
import io.github.sztuwebclub.webvoyager.constant.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class JwtTokenAdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String token = request.getHeader(JwtProperties.USER.getTokenName());

        try {
            log.info("jwt校验:{}", token);
            Claims claims = JwtUtil.parseJWT(token);
            Long userId = Long.valueOf(claims.get(JwtClaimsEnum.USER_ID.name()).toString());
            log.info("当前员工id: ", userId);
            ContextUtil.setCurrentId(userId);
            return true;
        } catch (Exception ex) {
            response.setStatus(401);
            return false;
        }
    }
}