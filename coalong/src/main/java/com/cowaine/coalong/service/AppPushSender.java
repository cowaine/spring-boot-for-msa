package com.cowaine.coalong.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class AppPushSender implements Sender {

    private final String endpoint;
    private final Integer port;
    private final Long timeout;

    @Override
    public boolean sendText(String phoneNumber, String message) {
        return false;
    }

}
