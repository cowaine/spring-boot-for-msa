package com.cowaine.corock.chapter05;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class HotelRoomRequest {

    private String roomNumber;
    private HotelRoomType hotelRoomType;
    private BigDecimal originalPrice;

}
