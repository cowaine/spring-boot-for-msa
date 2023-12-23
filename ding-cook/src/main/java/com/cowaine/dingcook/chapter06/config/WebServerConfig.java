package com.cowaine.dingcook.chapter06.config;

import com.cowaine.dingcook.chapter06.controller.converter.HotelRoomNumberConverter;
import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebServerConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new HotelRoomNumberConverter());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("www.springtour.io")
            .allowedMethods("GET", "POST", "PUT")
            .allowedHeaders("*")
            .maxAge(24 * 60 * 60);
    }

    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> defaultEncodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

        encodingFilter.setEncoding("utf-8"); // 기본 문자셋을 UTF-8로 설정
        encodingFilter.setForceEncoding(true); // 서블릿 필터가 적용되는 요청 메시지와 응답 메시지 모두 설정된 문자셋으로 인코딩한다.

        FilterRegistrationBean<CharacterEncodingFilter> filterBean = new FilterRegistrationBean<>();

        filterBean.setFilter(encodingFilter); // 새로 생성한 FilterRegistrationBean 객체에 setFilter()를 사용하여
        // CharacterEncoding Filter 서블릿 필터 객체를 설정한다.
        filterBean.addInitParameter("parameterName", "paramValue");
        filterBean.addUrlPatterns("*");
        filterBean.setOrder(1);

        return filterBean;
    }
}
