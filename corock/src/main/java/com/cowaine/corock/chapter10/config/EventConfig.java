package com.cowaine.corock.chapter10.config;

import com.cowaine.corock.chapter10.adaptor.event.EventListener;
import com.cowaine.corock.chapter10.adaptor.event.EventMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
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

    /**
     * {@link RedisMessageListenerContainer} 객체를 생성한다.
     * <p>
     * {@link RedisMessageListenerContainer} 객체는 {@link RedisTemplate} 과 마찬가지로
     * 레디스와 연결하려고 {@link RedisConnectionFactory} 객체를 사용한다.
     * 이때 {@link RedisMessageListenerContainer#setConnectionFactory(RedisConnectionFactory)} 메서드를 사용하면 된다.
     * <p>
     * {@link RedisMessageListenerContainer} 에 {@link MessageListener} 구현체를 등록한다.
     * 이때 {@link RedisMessageListenerContainer#addMessageListener(MessageListener, Topic)} 메서드는
     * {@link MessageListener} 객체와 {@link ChannelTopic} 객체를 인자로 받는다.
     * 등록된 {@link MessageListener} 객체는 {@link ChannelTopic} 의 토픽에서 받은 메시지를 처리한다.
     *
     * @return 레디스 메시지 리스너 컨테이너
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(this.eventRedisConnectionFactory());
        container.addMessageListener(this.eventListener(), this.eventTopic());

        return container;
    }

    @Bean
    public MessageListener eventListener() {
        return new EventListener(this.eventRedisTemplate());
    }

}
