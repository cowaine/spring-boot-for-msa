package com.cowaine.youngjujang.ch6.global.config;

import com.cowaine.youngjujang.ch6.domain.controller.converter.HotelRoomNumberConverter;
import com.cowaine.youngjujang.ch6.domain.controller.resolver.ClientInfoArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebServerConfig implements WebMvcConfigurer {
     @Override
     public void addFormatters(FormatterRegistry registry) {
          registry.addConverter(new HotelRoomNumberConverter());
     }
     
     @Override
     public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
          resolvers.add(new ClientInfoArgumentResolver());
     }
}
