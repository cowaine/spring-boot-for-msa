package com.cowaine.dingcook.chapter06.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelRoomController {

    @GetMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}")
    public ResponseEntity<String> getHotelRoomByPeriod(
        @PathVariable Long hotelId,
        @PathVariable String roomNumber
    ) {

        return ResponseEntity.ok("헬로우");
    }

}
