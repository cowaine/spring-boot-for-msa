package com.cowaine.corock.chapter07.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.ToString;

@ToString
public class HotelResponse {

    private final Long hotelId;
    private final String hotelName;
    private final String address;
    private final String phoneNumber;

    @Builder(access = AccessLevel.PRIVATE)
    private HotelResponse(Long hotelId, String hotelName, String address, String phoneNumber) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static HotelResponse create(Long hotelId, String hotelName, String address, String phoneNumber) {
        return HotelResponse.builder()
                .hotelId(hotelId)
                .hotelName(hotelName)
                .address(address)
                .phoneNumber(phoneNumber)
                .build();
    }

}
