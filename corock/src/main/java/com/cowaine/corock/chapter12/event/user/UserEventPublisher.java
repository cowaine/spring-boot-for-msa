package com.cowaine.corock.chapter12.event.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 사용자 이벤트 게시 클래스다.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishUserCreated(Long userId, String emailAddress) {
        UserEvent userEvent = UserEvent.created(this, userId, emailAddress);
        log.info("Publish user created event.");
        applicationEventPublisher.publishEvent(userEvent);
    }

}
