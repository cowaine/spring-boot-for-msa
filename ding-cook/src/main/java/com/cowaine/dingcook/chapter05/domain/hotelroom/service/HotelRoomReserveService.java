package com.cowaine.dingcook.chapter05.domain.hotelroom.service;

import java.time.LocalDate;

public interface HotelRoomReserveService {

    Long reserveHotelRoom(Long hotelId, String roomNumber, LocalDate checkInDate, LocalDate checkOutDate);
}
