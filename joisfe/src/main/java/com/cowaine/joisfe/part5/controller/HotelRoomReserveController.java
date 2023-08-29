package com.cowaine.joisfe.part5.controller;

import com.cowaine.joisfe.part5.domain.service.ReserveService;
import com.cowaine.joisfe.part5.dto.HotelRoomIdResponse;
import com.cowaine.joisfe.part5.dto.HotelRoomReserveRequest;
import com.cowaine.joisfe.part5.validator.HotelRoomReserveValidator;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public class HotelRoomReserveController {

    private final ReserveService reserveService;

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(new HotelRoomReserveValidator());
    }

    @PostMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}/reserve")
    public ResponseEntity<HotelRoomIdResponse> reserveHotelRoomByRoomNumber(
        @PathVariable Long hotelId,
        @PathVariable String roomNumber,
        @Valid @RequestBody HotelRoomReserveRequest reserveRequest,
        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMessage = new StringBuilder(bindingResult.getFieldError().getCode())
                .append(" [").append(fieldError.getField()).append("] ")
                .append(fieldError.getDefaultMessage())
                .toString();

            System.out.println("error  : " + errorMessage);
            return ResponseEntity.badRequest().build();
        }

        System.out.println(reserveRequest.toString());

        Long reservationId = reserveService.reserveHotelRoom(
            hotelId, roomNumber,
            reserveRequest.getCheckInDate(),
            reserveRequest.getCheckOutDate());

        HotelRoomIdResponse body = HotelRoomIdResponse.from(reservationId);
        return ResponseEntity.ok(body);
    }
}