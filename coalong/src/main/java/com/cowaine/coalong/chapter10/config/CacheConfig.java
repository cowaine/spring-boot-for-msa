package com.cowaine.coalong.chapter10.config;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.time.Duration;
import java.util.List;

@Slf4j
@Configuration
public class CacheConfig {

    @Bean
    public RedisConnectionFactory cacheRedisConnectionFactory() {
        // 레디스 서버의 주소와 IP 설정
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("127.0.0.1", 6379);
        // 레디스의 데이터베이스 번호 설정 (0~15까지 구분하여 운영)
        configuration.setDatabase(0);
        configuration.setUsername("username");
        configuration.setPassword("password");

        // 레디스와 클라이언트 커넥션 생성할 때 최대 소요시간 설정
        final SocketOptions socketOptions = SocketOptions.builder().connectTimeout(Duration.ofSeconds(10)).build();
        final ClientOptions clientOptions = ClientOptions.builder().socketOptions(socketOptions).build();

        LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
                .clientOptions(clientOptions)
                .commandTimeout(Duration.ofSeconds(5))  // 레디스 명령어를 실행하고 응답받는 시간을 설정
                .shutdownTimeout(Duration.ZERO)         // 애플리케이션이 종료될 때까지 기다리는 최대 시간
                .build();

        return new LettuceConnectionFactory(configuration, lettuceClientConfiguration);
    }

    @Bean
    public RedisConnectionFactory cacheRedisSentineConnectionFactory() {
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        // 레디스 센티넬이 모니터링할 레디스 서버 중 마스터 서버 이름
        configuration.setMaster("REDIS_MASTER_NAME");
        // sentinel() 메서드는 레디스 센티넬 서버를 추가하는 기능
        configuration.sentinel("127.0.0.1", 19999);
        configuration.sentinel("127.0.0.1", 19998);
        configuration.sentinel("127.0.0.1", 19997);
        configuration.setPassword("password");
        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisConnectionFactory cacheRedisClusterConnectionFactory() {
        RedisClusterConfiguration configuration = new RedisClusterConfiguration();
        // 에러시 Moved Redirection 처리 횟수를 설정
        configuration.setMaxRedirects(3);
        configuration.setClusterNodes(List.of(
                new RedisNode("127.0.0.1", 19999),
                new RedisNode("127.0.0.1", 19998),
                new RedisNode("127.0.0.1", 19997)
        ));

        return new LettuceConnectionFactory(configuration);
    }

}
