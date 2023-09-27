package com.cowaine.corock.chapter06.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 원하는 매핑 설정을 할 수 있도록 도와준다.
     *
     * @param configurer 사용자 요청을 매핑하는 세부 설정을 할 수 있는 메서드를 제공
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(true)       // URI 패스가 슬래시(/)로 끝나는 요청을 어떻게 처리할지 설정
            .addPathPrefix("/v2", HandlerTypePredicate.forAnnotation(RestController.class,
                                                                     Controller.class))
            .setPathMatcher(new AntPathMatcher())       // 컨트롤러 클래스에서 @RequestMapping 의 path 설정값과 사용자의 URI 를 매칭하는 역할
            .setUrlPathHelper(new UrlPathHelper());     // @PathVariable 의 값을 처리하는 데 사용
    }

    /**
     * {@link org.springframework.web.servlet.ViewResolver} 구현체 중 하나이다.
     *
     * @param configurer {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver} 의
     *                   콘텐츠 협상 기능을 상세히 설정할 수 있음
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.parameterName("contentType")                 // ContentNegotiatingViewResolver 에서 콘텐츠 협상 기능을 사용하기 위한 URI 파라미터 이름을 설정
            .ignoreAcceptHeader(true)                           // Accept 헤더를 사용한 콘텐츠 협상 기능을 사용하지 않도록 설정
            .defaultContentType(MediaType.APPLICATION_JSON)     // 콘텐츠 협상 과정에서 적합한 값을 찾지 못하면, 기본값으로 설정
            .mediaType("json", MediaType.APPLICATION_JSON)      // URI 파라미터 contentType 의 값이 json 이면 application.json 으로 간주
            .mediaType("xml", MediaType.APPLICATION_XML);       // URI 파라미터 contentType 의 값이 xml 이면 application.xml 로 간주
        new BigInteger(1_000, new Random()).add(BigInteger.TEN);
    }

    /**
     * 비동기 서블릿 기능을 설정할 때 사용한다.
     *
     * @param configurer 비동기 서블릿을 설정할 수 있는 객체
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        /*
         * 스프링 프레임워크에서 제공하는 스레드 풀을 설정
         * 스레드 풀의 스레드 이름은 "Async-Executor" 로 시작
         * 스레드 풀의 스레드 기본 개수는 50개이며 최대 100개까지 늘어날 수 있음
         * 스레드 풀의 대기열 크기는 300개
         */
        taskExecutor.setThreadNamePrefix("Async-Executor");
        taskExecutor.setCorePoolSize(50);
        taskExecutor.setMaxPoolSize(100);
        taskExecutor.setQueueCapacity(300);

        // 스레드 풀을 초기화하려면 반드시 initialize() 메서드를 호출해야 함
        taskExecutor.initialize();

        configurer.setTaskExecutor(taskExecutor);   // 생성한 스레드 풀을 설정
        configurer.setDefaultTimeout(10_000L);      // 비동기 처리 타임아웃을 설정하는 데 사용
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean(name = "localeResolver")
    public LocaleResolver localeResolver() {
        return new AcceptHeaderLocaleResolver();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        // converters.add(new MappingJackson2XmlHttpMessageConverter());
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        return objectMapper;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("locale");
        registry.addInterceptor(localeChangeInterceptor)
                .excludePathPatterns("/favicon.ico")
                .addPathPatterns("/**");
    }

    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> defaultCharacterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        characterEncodingFilter.setForceEncoding(true);

        FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(characterEncodingFilter);
        filterRegistrationBean.addInitParameter("paramName", "paramValue");
        filterRegistrationBean.addUrlPatterns("*");
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;
    }

}
