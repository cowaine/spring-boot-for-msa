package com.cowaine.joisfe.part5.dto;

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