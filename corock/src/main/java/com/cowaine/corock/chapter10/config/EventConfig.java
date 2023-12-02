package com.cowaine.corock.chapter10.config;

import com.cowaine.corock.chapter10.adaptor.event.EventMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class EventConfig {

    @Bean
    public RedisConnectionFactory eventRedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("127.0.0.1", 6379);
        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, String> eventRedisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(this.eventRedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        /*
         * JSON 메시지 포맷을 사용하므로 Jackson2JsonRedisSerializer 를 설정한다.
         * 이때 JSON 메시지 객체는 EventMessage.class 클래스 타입을 사용하므로
         * Jackson2JsonRedisSerializer 의 제네릭 타입과 생성자의 class 타입을 입력한다.
         */
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(EventMessage.class));

        return redisTemplate;
    }

    @Bean
    public ChannelTopic eventTopic() {
        return new ChannelTopic("dummyTopic");
    }

}
