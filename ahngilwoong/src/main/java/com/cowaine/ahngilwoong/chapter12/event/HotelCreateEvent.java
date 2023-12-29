package com.cowaine.ahngilwoong.chapter12.event;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HotelCreateEvent {

    private Long hotelId;
    private String hotelAddress;

    private HotelCreateEvent(Long hotelId, String hotelAddress) {
        this.hotelId = hotelId;
        this.hotelAddress = hotelAddress;
    }

    public static HotelCreateEvent of(Long hotelId, String hotelAddress) {
        return new HotelCreateEvent(hotelId, hotelAddress);
    }
}