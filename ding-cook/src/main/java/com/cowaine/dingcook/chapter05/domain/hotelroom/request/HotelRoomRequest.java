package com.cowaine.dingcook.chapter05.domain.hotelroom.request;

import com.cowaine.dingcook.chapter05.domain.hotelroom.HotelRoomType;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HotelRoomRequest {

    private String roomNumber;
    private HotelRoomType roomType;
    private BigDecimal originalPrice;
}
