package com.cowaine.corock.chapter09.config;

import com.cowaine.corock.chapter09.server.IdentityHeaderInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * 사용자 요청 후 대기 시간은 다음과 같이 계산할 수 있다.
     * <p>
     * 사용자의 대기 시간 = (Hotel API 의 요청 처리 시간 + Hotel API 와 사용자 구간의 네트워크 지연 시간 +
     *                  Billing API 의 요청 처리 시간 + Billing API 와 Hotel API 구간의 네트워크 지연 시간)
     *
     * @return REST-API 서버와 커넥션을 맺고 요청 메시지를 전달하고 응답 메시지를 받아 올 때까지 일련의 네트워킹 과정을 처리하는 인터페이스
     */
    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();

        factory.setConnectTimeout(3_000);
        factory.setReadTimeout(1_000);

        // SimpleClientHttpRequestFactory only
        // factory.setBufferRequestBody(false);

        return factory;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

        restTemplate.getInterceptors().add(new IdentityHeaderInterceptor());
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());

        return restTemplate;
    }

}
