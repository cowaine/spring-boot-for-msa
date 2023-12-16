package com.cowaine.corock.chapter12.service;

import com.cowaine.corock.chapter12.event.user.UserEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    // private final EventService eventService;
    private final UserEventPublisher userEventPublisher;

    public Boolean createUser(String username, String emailAddress) {
        // 사용자 생성 로직 생략
        // (...)

        // eventService.sendEventMail(emailAddress);
        log.info("created user. {}, {}", username, emailAddress);
        userEventPublisher.publishUserCreated(1_239_876L, emailAddress);
        log.info("done create user");

        return Boolean.TRUE;
    }

}
