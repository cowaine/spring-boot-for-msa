package com.cowaine.ahngilwoong.chapter7.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HotelRequest {
    private String hotelName;

    public HotelRequest() {
    }

    public HotelRequest(String hotelName) {
        this.hotelName = hotelName;
    }
}
