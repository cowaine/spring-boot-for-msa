package com.cowaine.youngjujang.ch6.global.config;

import com.cowaine.youngjujang.ch6.domain.controller.converter.HotelRoomNumberConverter;
import com.cowaine.youngjujang.ch6.domain.controller.resolver.ClientInfoArgumentResolver;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

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
     
     @Bean
     @Primary
     public ObjectMapper objectMapper(){
          ObjectMapper objectMapper = new ObjectMapper();
          objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY); //<< 종류 많음 ㅇㅇ 317p 참고
          return objectMapper;
     }
     
     @Override // 인터셉터 구현체 추가하기
     public void addInterceptors(InterceptorRegistry registry) {
//          WebMvcConfigurer.super.addInterceptors(registry);
          LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
          localeChangeInterceptor.setParamName("locale"); // locale 파라미터값을 locale 객체로 변경
          registry.addInterceptor(localeChangeInterceptor) // 인터셉터 추가.
               .excludePathPatterns("/favicon.ico") // 인터셉터 기능 제외할 url패턴
               .addPathPatterns("/**"); // 인터셉터가 동작할 경로 추가
     }
}
