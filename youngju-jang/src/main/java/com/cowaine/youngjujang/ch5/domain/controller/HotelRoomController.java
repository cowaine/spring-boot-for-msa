package com.cowaine.youngjujang.ch5.domain.controller;

import com.cowaine.youngjujang.ch5.domain.dto.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@RestController
public class HotelRoomController {
     
     private static final String HEADER_CREATED_AT = "X-CREATED-AT";
     private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
     
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
     
     @DeleteMapping (path = "/hotels/{hotelId}/rooms/{roomNumber}")
     public DeleteResultResponse deleteHotelRoom(
          @PathVariable Long hotelId,
          @PathVariable String roomNumber) {
          System.out.println("Delete Request. hotelId = " + hotelId);
          return new DeleteResultResponse(Boolean.TRUE, "success");
     }
     
     @PostMapping (path = "/hotels/{hotelId}/rooms")
     public ResponseEntity<HotelRoomIdResponse> createHotelRoom(
          @PathVariable Long hotelId,
          @RequestBody HotelRoomRequest hotelRoomRequest
     ){
          System.out.println(hotelRoomRequest.toString());
          
          MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
          headers.add(HEADER_CREATED_AT, DATE_FORMATTER.format(ZonedDateTime.now()));
          HotelRoomIdResponse body = HotelRoomIdResponse.from(1_002_003_004L);
          
          return new ResponseEntity<>(body, headers, HttpStatus.OK); // body, header, 상태코드
     }
}
