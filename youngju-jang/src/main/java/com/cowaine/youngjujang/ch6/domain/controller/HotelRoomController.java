package com.cowaine.youngjujang.ch6.domain.controller;

import com.cowaine.youngjujang.ch6.domain.dto.HotelRoomResponse;
import com.cowaine.youngjujang.ch6.domain.dto.HotelRoomType;
import com.cowaine.youngjujang.ch6.domain.HotelRoomNumber;
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
     
     @GetMapping (path = "/v6/hotels/{hotelId}/rooms/{roomNumber}")
     public HotelRoomResponse getHotelRoomByPeriod(
          @PathVariable Long hotelId,
          @PathVariable HotelRoomNumber roomNumber,
          @RequestParam (value = "fromDate", required = false)
          @DateTimeFormat (pattern = "yyyyMMdd") LocalDate fromDate,
          @RequestParam (value = "toDate", required = false)
          @DateTimeFormat (pattern = "yyyyMMdd") LocalDate toDate // 파라미터값 문자열을 LocalDate 타입으로 변환할때 패턴으로 파싱하여 변환. PathVariable 등에도 사용가능
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
                    .forEach(response::reservedAt);
          }
          return response;
     }
}
