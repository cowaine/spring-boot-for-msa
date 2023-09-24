package com.cowaine.coalong.service;

import com.cowaine.coalong.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotificationService {

    private final Sender messageSender;

    public boolean sendNotification(User user, String message) {
        return messageSender.sendText(user.getPhoneNumber(), message);
    }

}
