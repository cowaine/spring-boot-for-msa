package com.cowaine.joisfe.part8.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelCreateResponseDto {

    private Long hotelId;

    private HotelCreateResponseDto() {

    }

    public static HotelCreateResponseDto of(Long hotelId) {
        HotelCreateResponseDto response = new HotelCreateResponseDto();
        response.hotelId = hotelId;
        return response;
    }
}