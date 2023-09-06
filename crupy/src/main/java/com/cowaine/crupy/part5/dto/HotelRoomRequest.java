package com.cowaine.crupy.part5.dto;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class HotelRoomRequest {

    private String roomNumber;
    private HotelRoomType roomType;
    private BigDecimal originalPrice;
}
