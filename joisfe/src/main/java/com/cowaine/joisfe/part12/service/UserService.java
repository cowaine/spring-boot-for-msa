package com.cowaine.joisfe.part12.service;

import com.cowaine.joisfe.part12.event.user.UserEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserEventPublisher userEventPublisher;

    public Boolean createUser(String userName, String emailAddress) {
        log.info("created user. {}, {}", userName, emailAddress);
        userEventPublisher.publishUserCreated(1239876L, emailAddress);
        log.info("done create user");
        return Boolean.TRUE;
    }
}
