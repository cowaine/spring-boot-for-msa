package com.cowaine.coalong.chapter10.adapter.lock;

import java.util.Objects;

public class LockKey {

    private static final String PREFIX = "LOCK::";

    private Long eventHotelId;

    private LockKey(Long eventHotelId) {
        if (Objects.isNull(eventHotelId))
            throw new IllegalArgumentException("eventHotelId can't be null");
        this.eventHotelId = eventHotelId;
    }

    public static LockKey from(Long eventHotelId) {
        return new LockKey(eventHotelId);
    }

    // 레디스의 키로 저장할 때 직렬화 과정에서 사용할 메서드
    public static LockKey fromString(String key) {
        String idToken = key.substring(0, PREFIX.length());
        Long eventHotelId = Long.valueOf(idToken);

        return LockKey.from(eventHotelId);
    }

    // 레디스에 저장된 키를 LockKey 객체로 역직렬화할 때 사용할 메서드
    @Override
    public String toString() {
        return new StringBuilder(PREFIX).append(eventHotelId).toString();
    }

}
