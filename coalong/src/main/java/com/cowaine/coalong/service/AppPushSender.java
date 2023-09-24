package com.cowaine.coalong.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class AppPushSender {

    private final String endpoint;
    private final Integer port;
    private final Long timeout;

    public boolean sendText(String phoneNumber, String message) {
        return false;
    }

}
