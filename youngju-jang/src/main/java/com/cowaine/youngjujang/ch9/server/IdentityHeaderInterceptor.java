package com.cowaine.youngjujang.ch9.server;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class IdentityHeaderInterceptor implements ClientHttpRequestInterceptor {
     
     // 인터셉터용 HTTP헤더 이름, 값 상수값 정의
     private static final String COMPONENT_HEADER_NAME = "X-COMPONENT-ID";
     private static final String COMPOENT_HEADER_VALUE = "HOTEL-API";
     
     @Override
     public ClientHttpResponse intercept(HttpRequest request,
                                         byte[] body, 
                                         ClientHttpRequestExecution execution) throws IOException {
          request.getHeaders().addIfAbsent(COMPONENT_HEADER_NAME, COMPOENT_HEADER_VALUE); // 헤더설정 없을시 기본값 넣기
          return execution.execute(request,body); // 다음 인터셉터로 요청 전달
     }
}
