package com.cowaine.corock.chapter10.adaptor.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventMessage {

    private final Long timestamp;
    private final String message;

    /**
     * 게시자가 메시지를 생성할 때 생성자 내부에서 {@link EventMessage#timestamp} 값을 설정한다.
     *
     * @param message JSON 메시지
     */
    public EventMessage(String message) {
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }

    /**
     * {@link JsonCreator} 와 {@link JsonProperty} 애너테이션을 사용하여 JSON 메시지를 {@link EventMessage} 객체로 변환할 때 사용하는 생성자다.
     * 그러므로 구독자 쪽에서 사용하는 생성자가 된다.
     *
     * @param timestamp 타임스탬프
     * @param message JSON 메시지
     */
    @JsonCreator
    public EventMessage(@JsonProperty("timestamp") Long timestamp,
                        @JsonProperty("message") String message) {

        this.timestamp = timestamp;
        this.message = message;
    }

}
