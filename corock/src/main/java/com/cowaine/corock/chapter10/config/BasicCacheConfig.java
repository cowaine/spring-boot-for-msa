package com.cowaine.corock.chapter10.config;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@EnableCaching
@Configuration
public class BasicCacheConfig {

    @Bean
    public RedisConnectionFactory basicCacheRedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("127.0.0.1", 6379);

        final SocketOptions socketOptions = SocketOptions.builder().connectTimeout(Duration.ofSeconds(10L)).build();
        final ClientOptions clientOptions = ClientOptions.builder().socketOptions(socketOptions).build();

        LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
                .clientOptions(clientOptions)
                .commandTimeout(Duration.ofSeconds(5L))
                .shutdownTimeout(Duration.ZERO)
                .build();

        return new LettuceConnectionFactory(configuration, lettuceClientConfiguration);
    }

    /**
     * {@link RedisCacheConfiguration} 은 캐시 데이터를 저장하는 {@link org.springframework.data.redis.cache.RedisCache} 를 설정하는 기능을 제공한다.
     * {@link RedisCacheConfiguration#defaultCacheConfig()} 메서드는 기본값으로 설정된 {@link RedisCacheConfiguration} 객체를 응답한다.
     * <p>
     * {@link RedisCacheConfiguration#entryTtl(Duration)} 은 캐시 데이터의 유효 기간을 설정한다. 예제에 설정된 값은 1시간이다.
     * <p>
     * 캐시 데이터의 키를 직렬화할 때 {@link StringRedisSerializer} 를 사용한다. 즉, 문자열로 변환하여 저장한다.
     * <p>
     * 캐시 데이터의 값을 직렬화할 때는 {@link GenericJackson2JsonRedisSerializer} 를 사용한다.
     * JSON 메시지로 저장하는 것은 일반적인 방법 중 하나다.
     * <p>
     * {@link HashMap} configuration 객체의 키는 캐시 이름을 저장하고, 밸류는 캐시를 설정할 수 있는 {@link RedisCacheConfiguration} 을 저장한다.
     * hotelCache 캐시의 설정은 defaultConfig 설정과 같지만, {@link RedisCacheConfiguration#entryTtl(Duration)} 을 사용하여 캐시 데이터의 유효 기간을 30분으로 변경한다.
     * {@link RedisCacheConfiguration} 은 불변 객체이므로 {@link RedisCacheConfiguration#entryTtl(Duration)} 은 새로운 {@link RedisCacheConfiguration} 객체를 반환한다.
     * 그러므로 기존 defaultConfig 객체에는 영향이 없다.
     * <p>
     * {@link RedisCacheManagerBuilder#cacheDefaults(RedisCacheConfiguration)} 메서드는
     * {@link RedisCacheConfiguration} 의 기본 캐시를 설정한다. 예제에서는 defaultConfig 객체를 인자로 전달하고 있다.
     * <p>
     * {@link RedisCacheManagerBuilder#withInitialCacheConfigurations(Map)} 는 {@link RedisCacheManager} 를 생성할 때 초깃값을 설정한다.
     * 그러므로 {@link RedisCacheManager} 스프링 빈이 생성되면 hotelCache, hotelAddressCache 캐시 값이 설정된다.
     *
     * @return 캐시 매니저
     */
    @Bean
    public CacheManager cacheManager() {
        RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1L))
                .serializeKeysWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));

        Map<String, RedisCacheConfiguration> configurations = new HashMap<>();
        configurations.put("hotelCache", defaultConfig.entryTtl(Duration.ofMinutes(30L)));
        configurations.put("hotelAddressCache", defaultConfig.entryTtl(Duration.ofDays(1L)));

        return RedisCacheManagerBuilder
                .fromConnectionFactory(this.basicCacheRedisConnectionFactory())
                .cacheDefaults(defaultConfig)
                .withInitialCacheConfigurations(configurations)
                .build();
    }

}
