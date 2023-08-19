package com.cowaine.corock.chapter03.di;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class AppPushSender {

    private final String endpoint;
    private final int port;
    private final long timeout;

    public boolean sendText(String phoneNumber, String message) {
        return false;
    }

}
