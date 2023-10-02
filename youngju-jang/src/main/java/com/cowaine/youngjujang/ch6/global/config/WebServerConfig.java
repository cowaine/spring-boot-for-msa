package com.cowaine.youngjujang.ch6.global.config;

import com.cowaine.youngjujang.ch6.domain.controller.converter.HotelRoomNumberConverter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebServerConfig implements WebMvcConfigurer {
     @Override
     public void addFormatters(FormatterRegistry registry) {
          registry.addConverter(new HotelRoomNumberConverter());
     }
}
