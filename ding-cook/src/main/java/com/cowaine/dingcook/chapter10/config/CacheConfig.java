package com.cowaine.dingcook.chapter10.config;

import com.cowaine.dingcook.chapter10.cache.HotelCacheKey;
import com.cowaine.dingcook.chapter10.cache.HotelCacheKeySerializer;
import com.cowaine.dingcook.chapter10.cache.HotelCacheValue;
import com.cowaine.dingcook.chapter10.cache.HotelCacheValueSerializer;
import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import java.time.Duration;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@Configuration
public class CacheConfig {

    @Bean
    public RedisConnectionFactory cacheRedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("127.0.0.1", 6379);

        config.setDatabase(0);

        config.setUsername("username");
        config.setPassword("password");

        final SocketOptions socketOptions = SocketOptions.builder().connectTimeout(Duration.ofSeconds(10)).build();
        final ClientOptions clientOptions = ClientOptions.builder().socketOptions(socketOptions).build();

        LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
                                                                     .clientOptions(clientOptions)
                                                                     .commandTimeout(Duration.ofSeconds(5))
                                                                     .shutdownTimeout(Duration.ZERO)
                                                                     .build();

        return new LettuceConnectionFactory(config, lettuceClientConfiguration);
    }

    @Bean
    public RedisConnectionFactory cacheRedisConnectionFactory2() {
        RedisSentinelConfiguration config = new RedisSentinelConfiguration();
        config.setMaster("REDIS_MASTER_NAME");

        config.sentinel("127.0.0.1", 19999);
        config.sentinel("127.0.0.1", 19998);
        config.sentinel("127.0.0.1", 19997);

        config.setPassword("password");

        return new LettuceConnectionFactory(config);
    }

    @Bean
    public RedisConnectionFactory cacheRedisConnectionFactory3() {
        RedisClusterConfiguration config = new RedisClusterConfiguration();
        config.setMaxRedirects(3);

        config.setClusterNodes(
            List.of(
                new RedisNode("127.0.0.1", 19999),
                new RedisNode("127.0.0.1", 19998),
                new RedisNode("127.0.0.1", 19997)
            )
        );

        return new LettuceConnectionFactory(config);
    }

    @Bean(name = "hotelCacheRedisTemplate")
    public RedisTemplate<HotelCacheKey, HotelCacheValue> hotelCacheRedisTemplate() {
        RedisTemplate<HotelCacheKey, HotelCacheValue> hotelCacheRedisTemplate = new RedisTemplate<>();
        hotelCacheRedisTemplate.setConnectionFactory(cacheRedisConnectionFactory());
        hotelCacheRedisTemplate.setKeySerializer(new HotelCacheKeySerializer());
        hotelCacheRedisTemplate.setValueSerializer(new HotelCacheValueSerializer());
        return hotelCacheRedisTemplate;
    }
}
