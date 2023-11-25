package com.cowaine.joisfe.part10.config.cache;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@Configuration
public class CacheConfig {

    @Bean
    public RedisConnectionFactory cacheRedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("127.0.0.1", 6379);

        final SocketOptions socketOptions = SocketOptions.builder().connectTimeout(Duration.ofSeconds(10)).build();
        final ClientOptions clientOptions = ClientOptions.builder().socketOptions(socketOptions).build();

        LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
                                                                                          .clientOptions(clientOptions)
                                                                                          .commandTimeout(Duration.ofSeconds(5))
                                                                                          .shutdownTimeout(Duration.ZERO)
                                                                                          .build();

        return new LettuceConnectionFactory(configuration, lettuceClientConfiguration);
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