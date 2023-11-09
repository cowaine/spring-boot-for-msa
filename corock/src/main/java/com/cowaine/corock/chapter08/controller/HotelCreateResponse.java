package com.cowaine.corock.chapter08.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HotelCreateResponse {

    private final Long hotelId;

    public static HotelCreateResponse of(Long hotelId) {
        return new HotelCreateResponse(hotelId);
    }

}
