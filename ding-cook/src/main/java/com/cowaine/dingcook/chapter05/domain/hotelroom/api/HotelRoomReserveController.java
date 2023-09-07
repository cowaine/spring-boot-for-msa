package com.cowaine.dingcook.chapter05.domain.hotelroom.api;

import com.cowaine.dingcook.chapter05.domain.hotelroom.request.HotelRoomReserveRequest;
import com.cowaine.dingcook.chapter05.domain.hotelroom.response.HotelRoomIdResponse;
import com.cowaine.dingcook.chapter05.domain.hotelroom.service.HotelRoomReserveService;
import com.cowaine.dingcook.chapter05.domain.hotelroom.validator.HotelRoomReserveValidator;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HotelRoomReserveController {

    private final HotelRoomReserveService reserveService;

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(new HotelRoomReserveValidator());
    }

    @PostMapping("/hotels/{hotelId}/rooms/{roomNumber}/reserve")
    public ResponseEntity<HotelRoomIdResponse> reserveHotelRoomByRoomNumber(
        @PathVariable Long hotelId,
        @PathVariable String roomNumber,
        @Valid @RequestBody HotelRoomReserveRequest reserveRequest,
        BindingResult bindingResult
    ) {

        Long reservationId = reserveService.reserveHotelRoom(
            hotelId, roomNumber,
            reserveRequest.getCheckInDate(),
            reserveRequest.getCheckOutDate());

        HotelRoomIdResponse body = HotelRoomIdResponse.from(reservationId);

        return ResponseEntity.ok(body);
    }
}
