package com.cowaine.coalong.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class SmsSender {

    private final String endpoint;
    private final int port;
    private final long timeout;

    public boolean sendText(String phoneNumber, String message) {
        return false;
    }

}
