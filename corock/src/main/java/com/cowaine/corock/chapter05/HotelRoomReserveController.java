package com.cowaine.corock.chapter05;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HotelRoomReserveController {

    private final ReservationService reservationService;

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(new HotelRoomReserveValidator());
    }

    @PostMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}/reserve")
    public ResponseEntity<HotelRoomIdResponse> reserveHotelRoomByRoomNumber(@PathVariable final Long hotelId,
            @PathVariable final String roomNumber, @Valid @RequestBody final HotelRoomReserveRequest request,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMessage = new StringBuilder(fieldError.getCode())
                    .append(" [").append(fieldError.getField()).append("] ")
                    .append(fieldError.getDefaultMessage())
                    .toString();

            log.error("error: {}", errorMessage);
            return ResponseEntity.badRequest().build();
        }

        log.info(request.toString());

        Long reservationId = reservationService.reserveHotelRoom(hotelId, roomNumber, request.getCheckInDate(),
                request.getCheckOutDate());
        HotelRoomIdResponse body = HotelRoomIdResponse.from(reservationId);

        return ResponseEntity.ok(body);
    }

}
