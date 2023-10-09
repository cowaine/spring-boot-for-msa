package com.cowaine.corock.chapter07.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class HotelRequest {

    private String hotelName;

    @Builder
    public HotelRequest(String hotelName) {
        this.hotelName = hotelName;
    }

}
