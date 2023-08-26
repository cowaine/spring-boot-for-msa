package com.cowaine.corock.chapter05;

import com.cowaine.corock.chapter05.util.IdGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class HotelRoomResponse {

    @JsonProperty(namespace = "id")
    @JsonSerialize(using = ToStringSerializer.class)
    private final Long hotelRoomId;

    private final String roomNumber;

    private final HotelRoomType hotelRoomType;

    @JsonSerialize(using = ToDollarStringSerializer.class)
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

        @JsonProperty(namespace = "id")
        @JsonSerialize(using = ToStringSerializer.class)
        private final Long reservationId;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private final LocalDate reservedDate;

    }

}
