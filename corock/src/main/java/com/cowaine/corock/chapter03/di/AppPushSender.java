package com.cowaine.corock.chapter03.di;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class AppPushSender implements Sender {

    private final String endpoint;
    private final int port;
    private final long timeout;

    @Override
    public boolean sendText(String phoneNumber, String message) {
        return false;
    }

}
