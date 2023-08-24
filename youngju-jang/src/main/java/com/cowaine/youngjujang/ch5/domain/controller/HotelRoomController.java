package com.cowaine.youngjujang.ch5.domain.controller;

import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomResponse;
import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@RestController
public class HotelRoomController {
     
     @GetMapping (path = "/hotels/{hotelId}/rooms/{roomNumber}")
     public HotelRoomResponse getHotelRoomByPeriod(
          @PathVariable Long hotelId,
          @PathVariable String roomNumber,
          @RequestParam (value = "fromDate", required = false)
          @DateTimeFormat (pattern = "yyyyMMdd") LocalDate fromDate,
          @RequestParam (value = "toDate", required = false)
          @DateTimeFormat (pattern = "yyyyMMdd") LocalDate toDate
     ) {
          Long hotelRoomId = new Date().getTime();
          BigDecimal originalPrice = new BigDecimal("130.00");
          
          HotelRoomResponse response = HotelRoomResponse.of(
               hotelRoomId,
               roomNumber,
               HotelRoomType.DOUBLE,
               originalPrice
          );
          if (Objects.nonNull(fromDate) && Objects.nonNull(toDate)) {
               fromDate.datesUntil(toDate.plusDays(1))
                    .forEach(date -> response.reservedAt(date));
          }
          return response;
     }
}
