package com.cowaine.coalong.chapter09.config;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PoolingRestTemplateConfig {

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(100);           // 커넥션 풀에서 관리할 수 있는 총 커넥션 개수
        manager.setDefaultMaxPerRoute(5);   // 커넥션 풀에서 루트마다 관리할 수 있는 총 커넥션 개수 (default: 5)

        // 커넥션 풀에서 특정 루트마다 관리할 수 있는 총 커넥션 개수 설정.
        // defaultMaxPerRoute 설정을 덮어쓴다.
        HttpHost httpHost = new HttpHost("10.192.10.111", 8080, "http");
        manager.setMaxPerRoute(new HttpRoute(httpHost), 10);

        return manager;
    }

    @Bean
    public RequestConfig requestConfig() {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(3_000)
                .setConnectTimeout(3_000)
                .setSocketTimeout(1_000)
                .build();
    }

    @Bean
    public CloseableHttpClient httpClient() {
        return HttpClientBuilder.create()
                .setConnectionManager(this.poolingHttpClientConnectionManager())
                .setDefaultRequestConfig(this.requestConfig())
                .build();
    }

    @Bean
    public RestTemplate poolingRestTemplate() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(this.httpClient());

        return new RestTemplate(requestFactory);
    }

}