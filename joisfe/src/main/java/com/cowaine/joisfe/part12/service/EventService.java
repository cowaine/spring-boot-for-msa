package com.cowaine.joisfe.part12.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventService {

    public void sendEventMail(String emailAddress) {
        log.info("Send Email attached welcome coupons. {}", emailAddress);
    }
}
