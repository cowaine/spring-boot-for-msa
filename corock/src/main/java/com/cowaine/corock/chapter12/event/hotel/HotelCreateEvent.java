package com.cowaine.corock.chapter12.event.hotel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class HotelCreateEvent {

    private final Long hotelId;
    private final String hotelAddress;

    public static HotelCreateEvent of(Long hotelId, String hotelAddress) {
        return new HotelCreateEvent(hotelId, hotelAddress);
    }

}
