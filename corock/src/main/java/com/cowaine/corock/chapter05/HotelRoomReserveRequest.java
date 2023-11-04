package com.cowaine.corock.chapter05;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class HotelRoomReserveRequest {

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String name;

}
