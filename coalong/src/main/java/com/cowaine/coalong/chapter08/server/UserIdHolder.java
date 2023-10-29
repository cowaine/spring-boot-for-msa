package com.cowaine.coalong.chapter08.server;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserIdHolder {

    public static final ThreadLocal<String> threadLocalUserId = new ThreadLocal<>();

    public static String getUserId() {
        return threadLocalUserId.get();
    }

    public static void setUserId(String userId) {
        threadLocalUserId.set(userId);
    }

    public static void unset() {
        threadLocalUserId.remove();
    }

}
