package com.cowaine.joisfe.part4.controller;

import com.cowaine.joisfe.part4.domain.Hotel;
import com.cowaine.joisfe.part4.domain.HotelSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ApiController {

    private final HotelSearchService hotelSearchService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path="/hotels/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") Long hotelId) {
        Hotel hotel = hotelSearchService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }
}
