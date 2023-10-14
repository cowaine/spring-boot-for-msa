package com.cowaine.coalong.chapter07;

import com.cowaine.coalong.chapter07.dto.HotelRequest;
import com.cowaine.coalong.chapter07.dto.HotelResponse;
import com.cowaine.coalong.chapter07.service.DisplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotelController {

    private final DisplayService displayService;

    @PostMapping(path = "/hotels/fetch-by-name")
    public ResponseEntity<List<HotelResponse>> getHotelByName(@RequestBody HotelRequest hotelRequest) {
        List<HotelResponse> hotelResponses = displayService.getHotelsByName(hotelRequest);
        return ResponseEntity.ok(hotelResponses);
    }

}
