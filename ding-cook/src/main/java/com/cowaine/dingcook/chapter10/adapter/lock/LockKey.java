package com.cowaine.dingcook.chapter10.adapter.lock;

import java.util.Objects;

public class LockKey {

    private static final String PREFIX = "LOCK::";
    private Long eventHotelId;

    public LockKey(Long eventHotelId) {
        if (Objects.isNull(eventHotelId)) {
            throw new IllegalArgumentException("eventHotelId cat't be null");
        }

        this.eventHotelId = eventHotelId;
    }

    public static LockKey from(Long eventHotelId) {
        return new LockKey(eventHotelId);
    }

    public static LockKey fromString(String key) {
        String idToken = key.substring(0, PREFIX.length());
        Long eventHotelId = Long.valueOf(idToken);

        return LockKey.from(eventHotelId);
    }

    @Override
    public String toString() {
        return PREFIX + eventHotelId;
    }
}
