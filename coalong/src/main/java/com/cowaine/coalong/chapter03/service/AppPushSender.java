package com.cowaine.coalong.chapter03.service;

import org.springframework.stereotype.Component;

//@Builder
@Component
public class AppPushSender implements Sender {

    private final String endpoint;
    private final Integer port;
    private final Long timeout;

    public AppPushSender() {
        this.endpoint = "/";
        this.port = 5555;
        this.timeout = 1000L;
    }

    @Override
    public boolean sendText(String phoneNumber, String message) {
        return false;
    }

}
