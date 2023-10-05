package com.cowaine.youngjujang.ch6.global.config;

import com.cowaine.youngjujang.ch6.domain.controller.converter.HotelRoomNumberConverter;
import com.cowaine.youngjujang.ch6.domain.controller.resolver.ClientInfoArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
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
     
     @Override // 기존 설정된 httpMessageConverter대신 사용자가 추가한거 사용하는거 (기존꺼도 사용 : extendMessageConverters()
     public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
          // accept header : application/json, application/xml 따라 자동으로 변경되도록
//          WebMvcConfigurer.super.configureMessageConverters(converters);
          converters.add(new MappingJackson2HttpMessageConverter()); // convert json message
          converters.add(new MappingJackson2XmlHttpMessageConverter());// convert xml message
     }
}
