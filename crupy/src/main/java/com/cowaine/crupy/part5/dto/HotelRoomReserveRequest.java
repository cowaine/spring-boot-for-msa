package com.cowaine.crupy.part5.dto;

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
