package com.cowaine.coalong.chapter03.service;

import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public class SmsSender implements Sender {

    private final String endpoint;
    private final int port;
    private final long timeout;

    public SmsSender() {
        this.endpoint = "/";
        this.port = 5555;
        this.timeout = 1000L;
    }

    @Override
    public boolean sendText(String phoneNumber, String message) {
        return false;
    }

}
