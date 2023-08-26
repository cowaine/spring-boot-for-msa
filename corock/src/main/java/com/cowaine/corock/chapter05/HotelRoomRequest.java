package com.cowaine.corock.chapter05;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@ToString
public class HotelRoomRequest {

    private final String roomNumber;
    private final HotelRoomType hotelRoomType;
    private final BigDecimal originalPrice;

}
