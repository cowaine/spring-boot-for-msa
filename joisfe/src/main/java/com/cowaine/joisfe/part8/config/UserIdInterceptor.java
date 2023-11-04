package com.cowaine.joisfe.part8.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class UserIdInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response,
        Object handler) {

        String userId = request.getHeader("user-id");
        UserIdHolder.setUserId(userId);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
        HttpServletResponse response,
        Object handler, Exception ex) {
        UserIdHolder.unset();
    }
}