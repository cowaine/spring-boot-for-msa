package com.cowaine.youngjujang.ch5.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Builder
public class HotelRoomResponse {
     private Long hotelRoomId;
     private String roomNumber;
     private int numberOfBeds;
     private HotelRoomType roomType;
     private BigDecimal originalPrice;
     private List<Reservation> reservations;
     
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
     
     public void reservedAt(LocalDate date){
          Long reservationId = new Date().getTime();
          this.reservations.add(new Reservation(reservationId, date));
     }
     
     @JsonSerialize
     @RequiredArgsConstructor
     public static class Reservation {
          private final Long reservationId;
          private final LocalDate reservedDate;
     }
     
     
}
