package com.cowaine.corock.chapter10.service;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class HotelResponse {

    private final Long hotelId;
    private final String hotelName;
    private final String hotelAddress;

    @Builder(access = AccessLevel.PRIVATE)
    private HotelResponse(Long hotelId, String hotelName, String hotelAddress) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
    }

    public static HotelResponse create(Long hotelId, String hotelName, String hotelAddress) {
        return HotelResponse.builder()
                .hotelId(hotelId)
                .hotelName(hotelName)
                .hotelAddress(hotelAddress)
                .build();
    }

}
