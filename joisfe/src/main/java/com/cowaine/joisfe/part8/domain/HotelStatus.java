package com.cowaine.joisfe.part8.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum HotelStatus {

    OPEN(1), CLOSED(-1), READY(0);

    private static final Map<Integer, HotelStatus> valueMap = Arrays.stream(HotelStatus.values())
                                                                    .collect(Collectors.toMap(HotelStatus::getValue,
                                                                  Function.identity()));

    private final Integer value;

    HotelStatus(Integer value) {
        this.value = value;
    }

    public static HotelStatus fromValue(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("value is null");
        }

        return valueMap.get(value);
    }

    public Integer getValue() {
        return value;
    }
}