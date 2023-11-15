package com.cowaine.youngjujang.ch9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
     // 메서드 실행 >> RestTemplate >> ClientHttpRequeestFactory >> 서버
     //  응답     <<              <<                           <<
     @Bean
     public ClientHttpRequestFactory clientHttpRequestFactory(){
          // RestTemplate의 ClientHttpRequestFactory구현체로서 사용
          SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
          
          factory.setConnectTimeout(3000);// 커넥션 객체생성 최대시간, 밀리초 단위, (0: 무기한대기)
          factory.setReadTimeout(1000);// 요청, 응답까지 소요 최대시간
          factory.setBufferRequestBody(false); // 요청메시지의 바디를 버퍼링(저장목적: 클수록 메모리문제발생)하지 않겠다(default : true)
          
          return factory;
     }
     
     @Bean
     public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory){
          RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory); // 위 bean을 주입받아 객체생성
          
          restTemplate.getInterceptors().add(new IdentityHeaderInterceptor()); // 새로운 인터셉터객체 추가. 새로생성한 인터셉터임
          restTemplate.setErrorHandler(new DefaultResponseErrorHandler()); // 에러핸들러 설정. 기본핸들러로
          
          return restTemplate;
     }
}
