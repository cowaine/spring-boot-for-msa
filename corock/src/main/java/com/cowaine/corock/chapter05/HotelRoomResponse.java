package com.cowaine.corock.chapter05;

import com.cowaine.corock.chapter05.util.IdGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class HotelRoomResponse {

    private final Long hotelRoomId;
    private final String roomNumber;
    private final HotelRoomType hotelRoomType;
    private final BigDecimal originalPrice;
    private final List<Reservation> reservations;

    public static HotelRoomResponse of(Long hotelRoomId, String roomNumber, HotelRoomType hotelRoomType, BigDecimal originalPrice) {
        return new HotelRoomResponse(hotelRoomId, roomNumber, hotelRoomType, originalPrice, new ArrayList<>());
    }

    public void reservedAt(LocalDate reservedAt) {
        reservations.add(new Reservation(IdGenerator.create(), reservedAt));
    }

    @RequiredArgsConstructor
    @Getter
    private static class Reservation {
        private final Long reservationId;
        private final LocalDate reservedDate;
    }

}
