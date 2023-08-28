package com.cowaine.dingcook.chapter05.domain.hotelroom.request;

import java.time.LocalDate;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HotelRoomReserveRequest {

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String name;
}
