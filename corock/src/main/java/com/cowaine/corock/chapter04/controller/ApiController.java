package com.cowaine.corock.chapter04.controller;

import com.cowaine.corock.chapter04.domain.Hotel;
import com.cowaine.corock.chapter04.domain.HotelSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final HotelSearchService hotelSearchService;

    @GetMapping(path = "/hotels/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") final Long id) {
        Hotel hotel = hotelSearchService.getHotelById(id);
        return ResponseEntity.ok(hotel);
    }

}
