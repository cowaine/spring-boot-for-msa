package com.cowaine.coalong.service;

import com.cowaine.coalong.User;

public class NotificationService {

    public boolean sendNotification(User user, String message) {
        SmsSender smsSender = SmsSender.builder()
                .endpoint("/send")
                .port(5555)
                .timeout(5_000L)
                .build();

        return smsSender.sendText(user.getPhoneNumber(), message);
    }

}
