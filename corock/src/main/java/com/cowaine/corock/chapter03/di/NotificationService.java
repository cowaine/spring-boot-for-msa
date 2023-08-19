package com.cowaine.corock.chapter03.di;

import com.cowaine.corock.chapter03.User;

public class NotificationService {

    private final Sender messageSender;

    public NotificationService(Sender messageSender) {
        this.messageSender = messageSender;
    }

    public boolean sendNotification(User user, String message) {
        return messageSender.sendText(user.getPhoneNumber(), message);
    }

}
