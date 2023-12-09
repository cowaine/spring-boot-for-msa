package com.cowaine.corock.chapter10.adaptor.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * {@link EventPublisher} 스프링 빈은 {@link EventPublisher#eventRedisTemplate} 과 {@link EventPublisher#eventTopic} 스프링 빈을 주입받는다.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EventPublisher {

    private final RedisTemplate<String, String> eventRedisTemplate;
    private final ChannelTopic eventTopic;

    /**
     * 토픽 이름과 메시지를 인자로 받는다. 그래서 토픽에 메시지를 전달한다.
     * {@link RedisTemplate#convertAndSend(String, Object)} 메서드 내부에는
     * {@link org.springframework.web.client.RestTemplate} 의 값을 변환하는
     * {@link org.springframework.data.redis.serializer.RedisSerializer} valueSerializer 로 메시지가 변환된다.
     * 이 valueSerializer 를 설정하려면 {@link RedisTemplate#setValueSerializer(RedisSerializer)} 메서드를 사용한다.
     *
     * @param eventMessage 이벤트 메시지 객체
     */
    public void sendMessage(EventMessage eventMessage) {
        eventRedisTemplate.convertAndSend(eventTopic.getTopic(), eventMessage);
    }

}
