package com.cowaine.youngjujang.ch8.scheme.server;

public class UserIdHoder {
     
     private static final ThreadLocal<String> threadLocalUserId = new ThreadLocal<>();
     
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
