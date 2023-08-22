package com.cowaine.corock.chapter04.controller;

import com.cowaine.corock.chapter04.domain.Hotel;
import com.cowaine.corock.chapter04.domain.HotelSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class ApiController {

    private HotelSearchService hotelSearchService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/hotels/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") Long hotelId) {
        Hotel hotel = hotelSearchService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }

}
