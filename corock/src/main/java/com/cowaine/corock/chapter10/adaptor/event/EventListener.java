package com.cowaine.corock.chapter10.adaptor.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Slf4j
public class EventListener implements MessageListener {

    private RedisTemplate<String, String> eventRedisTemplate;
    private RedisSerializer<EventMessage> valueSerializer;

    /**
     * {@link MessageListener} 에서 수신한 {@link Message} 객체는 byte[] 타입의 로우 데이터를 반환한다.
     * 그러므로 자바 객체로 변환하려면 {@link RedisSerializer} 가 필요하다.
     * 예제 코드에서는 {@link EventListener#eventRedisTemplate} 의 valueSerializer 의
     * {@link RedisSerializer#deserialize(byte[])} 메서드를 사용하면 {@link EventMessage} 객체로 변환할 수 있다.
     *
     * @param eventRedisTemplate Pub-Sub 용 레디스 템플릿
     */
    public EventListener(RedisTemplate<String, String> eventRedisTemplate) {
        this.eventRedisTemplate = eventRedisTemplate;
        this.valueSerializer = (RedisSerializer<EventMessage>) eventRedisTemplate.getValueSerializer();
    }

    /**
     * 레디스에서 구독한 메시지 객체인 {@link Message#getBody()} 메서드는 게시자가 토픽에 게시한 메시지를 응답한다.
     * 그러므로 {@link RedisSerializer#deserialize(byte[])} 메서드를 사용하면 {@link EventMessage} 객체로 변환할 수 있다.
     * <p>
     * {@link Message#getChannel()} 메서드를 사용하면 어떤 토픽에서 메시지를 구독했는지 확인할 수 있다.
     * byte[] 타입을 반환하므로 문자열로 변환하는 과정이 필요하다. 그러므로 new String() 을 사용했다.
     *
     * @param message message must not be {@literal null}.
     * @param pattern pattern matching the channel (if specified) - can be {@literal null}.
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        EventMessage eventMessage = valueSerializer.deserialize(message.getBody());

        log.warn("Subscribe Channel: {}", new String(message.getChannel()));
        log.warn("Subscribe Message: {}", eventMessage.toString());
    }

}
