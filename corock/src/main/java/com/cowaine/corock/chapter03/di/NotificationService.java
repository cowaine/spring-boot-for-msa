package com.cowaine.corock.chapter03.di;

import com.cowaine.corock.chapter03.User;

public class NotificationService {

    public boolean sendNotification(User user, String message) {
        // SmsSender smsSender = SmsSender.builder()
        AppPushSender appPushSender = AppPushSender.builder()
                .endpoint("/send")
                .port(9180)
                .timeout(4_000L)
                .build();

        // return smsSender.sendText(user.getPhoneNumber(), message);
        return appPushSender.sendText(user.getPhoneNumber(), message);
    }

}
