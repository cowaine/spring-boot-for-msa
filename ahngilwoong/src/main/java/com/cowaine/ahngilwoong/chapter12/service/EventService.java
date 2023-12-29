package com.cowaine.ahngilwoong.chapter12.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventService {

    public void sendEventMail(String emailAddress) {
        log.info("email send = {}", emailAddress);
    }
}