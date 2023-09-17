package com.cowaine.corock.chapter05;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum HotelRoomType {

    SINGLE("single"),
    DOUBLE("double"),
    TRIPLE("triple"),
    QUAD("quad");

    private static final Map<String, HotelRoomType> paramMap = Arrays.stream(HotelRoomType.values())
            .collect(Collectors.toMap(HotelRoomType::getParam, Function.identity()));

    private final String param;

    @JsonCreator
    public static HotelRoomType fromParam(String param) {
        return Optional.ofNullable(param)
                .map(paramMap::get)
                .orElseThrow(() -> new IllegalArgumentException("param is not valid"));
    }

    @JsonValue
    public String getParam() {
        return param;
    }

}
