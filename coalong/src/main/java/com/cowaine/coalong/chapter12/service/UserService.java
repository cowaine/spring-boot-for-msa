package com.cowaine.coalong.chapter12.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EventService eventService;

    public Boolean createUser(String username, String emailAddress) {
        // 사용자 생성 로직 생략

        eventService.sendEventMail(emailAddress);
        return Boolean.TRUE;
    }

}
