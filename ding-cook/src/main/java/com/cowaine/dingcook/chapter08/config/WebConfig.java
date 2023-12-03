package com.cowaine.dingcook.chapter08.config;

import com.cowaine.dingcook.chapter08.server.UserIdInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public UserIdInterceptor userIdInterceptor() {
        return new UserIdInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userIdInterceptor());
    }
}
