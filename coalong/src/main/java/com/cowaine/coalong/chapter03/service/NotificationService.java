package com.cowaine.coalong.chapter03.service;

import com.cowaine.coalong.chapter03.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotificationService {

    private final Sender messageSender;

    public boolean sendNotification(User user, String message) {
        return messageSender.sendText(user.getPhoneNumber(), message);
    }

}
