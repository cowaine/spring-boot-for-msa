package com.cowaine.ahngilwoong.chapter8.api;


import com.cowaine.ahngilwoong.chapter8.model.HotelCreateRequest;
import com.cowaine.ahngilwoong.chapter8.model.HotelCreateResponse;
import com.cowaine.ahngilwoong.chapter8.model.HotelResponse;
import com.cowaine.ahngilwoong.chapter8.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping(path = "/hotels")
    public ResponseEntity<HotelCreateResponse> createHotel(@RequestBody HotelCreateRequest request) {
        HotelCreateResponse response = hotelService.createHotel(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/hotels/{hotelId}")
    public ResponseEntity<HotelResponse> getHotelById(@PathVariable("hotelId") Long hotelId) {
        HotelResponse hotelResponse = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotelResponse);
    }
}
