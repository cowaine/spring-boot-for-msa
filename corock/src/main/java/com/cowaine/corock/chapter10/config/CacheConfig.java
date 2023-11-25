package com.cowaine.corock.chapter10.config;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.time.Duration;
import java.util.List;

@Configuration
public class CacheConfig {

    @Bean
    public RedisConnectionFactory cacheRedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("127.0.0.1", 6379);
        configuration.setDatabase(0);
        configuration.setUsername("username");
        configuration.setPassword("password");

        final SocketOptions socketOptions = SocketOptions.builder().connectTimeout(Duration.ofSeconds(10)).build();
        final ClientOptions clientOptions = ClientOptions.builder().socketOptions(socketOptions).build();

        LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
                .clientOptions(clientOptions)
                .commandTimeout(Duration.ofSeconds(5))
                .shutdownQuietPeriod(Duration.ZERO)
                .build();

        return new LettuceConnectionFactory(configuration, lettuceClientConfiguration);
    }

    @Bean
    public RedisConnectionFactory cacheRedisSentinelConnectionFactory() {
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        configuration.setMaster("REDIS_MASTER_NAME");
        List<RedisNode> redisNodes = List.of(new RedisNode("127.0.0.1", 19999),
                new RedisNode("127.0.0.1", 19998), new RedisNode("127.0.0.1", 19997));
        configuration.setSentinels(redisNodes);

        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisConnectionFactory cacheRedisClusterConnectionFactory() {
        RedisClusterConfiguration configuration = new RedisClusterConfiguration();
        configuration.setMaxRedirects(3);
        configuration.setClusterNodes(List.of(new RedisNode("127.0.0.1", 19999),
                new RedisNode("127.0.0.1", 19998), new RedisNode("127.0.0.1", 19997)));

        return new LettuceConnectionFactory(configuration);
    }

}
