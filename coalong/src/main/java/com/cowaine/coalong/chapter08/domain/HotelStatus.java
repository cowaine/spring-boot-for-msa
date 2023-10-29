package com.cowaine.coalong.chapter08.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum HotelStatus {

    OPEN(1), CLOSED(-1), READY(0);

    private static Map<Integer, HotelStatus> valueMap = Arrays.stream(HotelStatus.values())
            .collect(Collectors.toMap(HotelStatus::getValue, Function.identity()));

    private final Integer value;

    public static HotelStatus fromValue(Integer value) {
        if (value == null)
            throw new IllegalArgumentException("value is null");

        return valueMap.get(value);
    }

}
