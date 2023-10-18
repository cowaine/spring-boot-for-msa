package com.cowaine.dingcook.chapter07.controller;

import com.cowaine.dingcook.chapter07.service.HotelDisplayService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HotelController {

    private final HotelDisplayService hotelDisplayService;

    @ResponseBody
    @PostMapping("/hotels/fetch-by-name")
    public ResponseEntity<List<HotelResponse>> getHotelByName(@RequestBody HotelRequest hotelRequest) {
        List<HotelResponse> hotelResponses = hotelDisplayService.getHotelsByName(hotelRequest);

        return ResponseEntity.ok(hotelResponses);
    }
}
