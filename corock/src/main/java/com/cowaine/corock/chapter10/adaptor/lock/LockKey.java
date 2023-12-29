package com.cowaine.corock.chapter10.adaptor.lock;

import java.util.Objects;

public class LockKey {

    public static final String PREFIX = "LOCK::";

    private final Long eventHotelId;

    private LockKey(Long eventHotelId) {
        if (Objects.isNull(eventHotelId)) {
            throw new IllegalArgumentException("eventHotelId can't be null");
        }
        this.eventHotelId = eventHotelId;
    }

    @Override
    public String toString() {
        return new StringBuilder(PREFIX).append(eventHotelId).toString();
    }

    public static LockKey from(Long eventHotelId) {
        return new LockKey(eventHotelId);
    }

    public static LockKey fromString(String key) {
        String idToken = key.substring(0, PREFIX.length());
        Long eventHotelId = Long.valueOf(idToken);

        return LockKey.from(eventHotelId);
    }

}
