package com.cowaine.dingcook.domain.chapter04.api;

import com.cowaine.dingcook.domain.chapter04.entity.Hotel;
import com.cowaine.dingcook.domain.chapter04.service.HotelSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequiredArgsConstructor
public class ApiController {

    private final HotelSearchService hotelSearchService;

    @RequestMapping("/hotels/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelId) {
        Hotel hotel = hotelSearchService.getHotelById(hotelId);

        return ResponseEntity.ok(hotel);
    }
}
