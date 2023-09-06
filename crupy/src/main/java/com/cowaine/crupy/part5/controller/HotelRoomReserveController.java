package com.cowaine.crupy.part5.controller;

import com.cowaine.crupy.part5.dto.HotelRoomIdResponse;
import com.cowaine.crupy.part5.dto.HotelRoomReserveRequest;
import com.cowaine.crupy.part5.exception.BadRequestException;
import com.cowaine.crupy.part5.validator.HotelRoomReserveValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HotelRoomReserveController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleException(BadRequestException ex){

    }
    @InitBinder
    void initBinder(WebDataBinder binder){
        binder.addValidators(new HotelRoomReserveValidator());
    }

    @PostMapping("/hotels/{hotelId}/rooms/{roomNumber}/reserve")
    public ResponseEntity<HotelRoomIdResponse> reserveHotelRoomByRoomNumber(
            @PathVariable Long hotelId,
            @PathVariable String roomNumber,
            @Valid @RequestBody HotelRoomReserveRequest reserveRequest,
            BindingResult bindingResult){

        Long reservationId = reserveService.reserveHotelRoom(
                hotelId, roomNumber,
                reserveRequest.getCheckInDate(),
                reserveRequest.getCheckOutDate()
        );

        HotelRoomIdResponse body = HotelRoomIdResponse.from(reservationId);
        return ResponseEntity.ok(body);
    }
}
