package com.cowaine.youngjujang.ch5.domain.dto;

import com.cowaine.youngjujang.ch5.domain.utils.ToDollarStringSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.IdGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Builder
public class HotelRoomResponse {
     @JsonProperty("id") // hotelRoomId 대신 id가 속성명이 됨
     @JsonSerialize(using = ToStringSerializer.class) // Long > String 으로 마셜링
     private final Long hotelRoomId;
     private final String roomNumber;
     private final int numberOfBeds;
     private final HotelRoomType roomType; // enum type
     @JsonSerialize(using = ToDollarStringSerializer.class) // 직접구현. BigDecimal > $
     private final BigDecimal originalPrice;
     private final List<Reservation> reservations;
     
     public static HotelRoomResponse of(
          Long hotelRoomId,
          String roomNumber,
          HotelRoomType hotelRoomType,
          BigDecimal originalPrice
     ) {
          return HotelRoomResponse.builder()
               .hotelRoomId(hotelRoomId)
               .roomNumber(roomNumber)
               .roomType(hotelRoomType)
               .originalPrice(originalPrice)
               .reservations(new ArrayList<>())
               .build();
     }
     
     public void reservedAt(LocalDate reservedAt){
          //Long reservationId = IdGenerator.create();
          Long reservationId = new Date().getTime();
          this.reservations.add(new Reservation(reservationId, reservedAt));
     }
     
     @Getter
     @JsonSerialize
     @RequiredArgsConstructor
     public static class Reservation {
          @JsonProperty("id")
          @JsonSerialize(using = ToStringSerializer.class)
          private final Long reservationId;
          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // LocalDate type > 사용자정의 포맷으로 변경
          private final LocalDate reservedDate;
     }
     
     
}
