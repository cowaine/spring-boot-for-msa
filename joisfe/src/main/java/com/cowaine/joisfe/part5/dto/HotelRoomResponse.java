package com.cowaine.joisfe.part5.dto;

import com.cowaine.joisfe.part5.domain.HotelRoomType;
import com.cowaine.joisfe.part5.serializer.ToDollarStringSerializer;
import com.cowaine.joisfe.part5.utils.IdGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * @author : 조재철
 * @since 1.0
 */
public class HotelRoomResponse {

    @JsonProperty("id")
    @JsonSerialize(using = ToStringSerializer.class)
    private final Long hotelRoomId;

    private final String roomNumber;

    private final HotelRoomType hotelRoomType;

    @JsonSerialize(using = ToDollarStringSerializer.class)
    private final BigDecimal originalPrice;

    private final List<Reservation> reservations;

    private HotelRoomResponse(Long hotelRoomId, String roomNumber, HotelRoomType hotelRoomType, BigDecimal originalPrice) {
        this.hotelRoomId = hotelRoomId;
        this.roomNumber = roomNumber;
        this.hotelRoomType = hotelRoomType;
        this.originalPrice = originalPrice;
        reservations = new ArrayList<>();
    }

    public static HotelRoomResponse of(Long hotelRoomId, String roomNumber, HotelRoomType hotelRoomType, BigDecimal originalPrice) {
        return new HotelRoomResponse(hotelRoomId, roomNumber, hotelRoomType, originalPrice);
    }

    public void reservedAt(LocalDate reservedAt) {
        reservations.add(new Reservation(IdGenerator.create(), reservedAt));
    }

    @Getter
    private static class Reservation {

        @JsonProperty("id")
        @JsonSerialize(using = ToStringSerializer.class)
        private final Long reservationId;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private final LocalDate reservedDate;

        public Reservation(Long reservationId, LocalDate reservedDate) {
            this.reservationId = reservationId;
            this.reservedDate = reservedDate;
        }
    }
}
