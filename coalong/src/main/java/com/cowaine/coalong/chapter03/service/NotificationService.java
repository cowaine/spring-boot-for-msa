package com.cowaine.coalong.chapter03.service;

import com.cowaine.coalong.chapter03.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final Sender messageSender;

    public NotificationService(@Qualifier("appPushSender") Sender messageSender) {
        this.messageSender = messageSender;
    }

    public boolean sendNotification(User user, String message) {
        return messageSender.sendText(user.getPhoneNumber(), message);
    }

}
