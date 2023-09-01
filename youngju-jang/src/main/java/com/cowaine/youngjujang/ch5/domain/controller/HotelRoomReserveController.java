package com.cowaine.youngjujang.ch5.domain.controller;

import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomIdResponse;
import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomReserveRequest;
import com.cowaine.youngjujang.ch5.domain.service.ReserveService;
import com.cowaine.youngjujang.ch5.domain.utils.validator.HotelRoomReserveValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HotelRoomReserveController {
     
     private final ReserveService reserveService;
     
     @InitBinder
     void initBinder(WebDataBinder binder) {
          binder.addValidators(new HotelRoomReserveValidator());
     }
     
     @PostMapping (path = "/hotels/{hotelId}/rooms/{roomNumber}/reserve")
     public ResponseEntity<HotelRoomIdResponse> reserveHotelRoomByRoomNumber(
          @PathVariable Long hotelId,
          @PathVariable String roomNumber,
          @Valid @RequestBody HotelRoomReserveRequest reserveRequest,
          BindingResult bindingResult
          ){
//          Long reservationId = reserveService.reserveHotelRoom(hotelId,
//               roomNumber,
//               reserveRequest.getCheckInDate(),
//               reserveRequest.getCheckOutDate());
          
//          HotelRoomIdResponse body = HotelRoomIdResponse.from(reservationId);
          log.info("checkInDate : {} , checkOutDate : {}", reserveRequest.getCheckInDate(), reserveRequest.getCheckOutDate());
          HotelRoomIdResponse body = HotelRoomIdResponse.from(1_002_003_004L);
          return ResponseEntity.ok(body);
     }
     
}
