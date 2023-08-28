package com.cowaine.youngjujang.ch5.domain.controller;

import com.cowaine.youngjujang.ch5.domain.dto.DeleteResultResponse;
import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomResponse;
import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

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
          @DateTimeFormat (pattern = "yyyyMMdd") LocalDate toDate // 파라미터값 문자열을 LocalDate 타입으로 변환할때 패턴으로 파싱하여 변환. PathVariable 등에도 사용가능
//          @RequestHeader(value = "x-from-date", required = false)
//          @DateTimeFormat (pattern = "yyyyMMdd") LocalDate fromDate,
//          @RequestHeader(value = "x-to-date", required = false)
//          @DateTimeFormat (pattern = "yyyyMMdd") LocalDate toDate,
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
     
     @DeleteMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}")
     public DeleteResultResponse deleteHotelRoome(
          @PathVariable Long hotelId,
          @PathVariable String roomNumber){
          System.out.println("Delete Request. hotelId = " + hotelId);
          return new DeleteResultResponse(Boolean.TRUE, "success");
     }
}
