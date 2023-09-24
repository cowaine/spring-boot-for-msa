package com.cowaine.coalong.service;

import com.cowaine.coalong.User;

public class NotificationService {

    public boolean sendNotification(User user, String message) {
        AppPushSender appPushSender = AppPushSender.builder()
                .endpoint("/send")
                .port(5555)
                .timeout(5_000L)
                .build();

        return appPushSender.sendText(user.getPhoneNumber(), message);
    }

}
