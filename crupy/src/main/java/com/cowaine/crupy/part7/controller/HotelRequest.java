package com.cowaine.crupy.part7.controller;

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