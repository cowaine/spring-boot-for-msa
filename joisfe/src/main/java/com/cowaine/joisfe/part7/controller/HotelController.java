package com.cowaine.joisfe.part7.controller;

import com.cowaine.joisfe.part7.dto.HotelRequest;
import com.cowaine.joisfe.part7.dto.HotelResponse;
import com.cowaine.joisfe.part7.service.HotelDisplayService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class HotelController {

    private HotelDisplayService hotelDisplayService;

    public HotelController(HotelDisplayService hotelDisplayService) {
        this.hotelDisplayService = hotelDisplayService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/hotels/fetch-by-name")
    public ResponseEntity<List<HotelResponse>> getHotelByName(@RequestBody HotelRequest hotelRequest) {
        List<HotelResponse> hotelResponses = hotelDisplayService.getHotelsByName(hotelRequest);
        return ResponseEntity.ok(hotelResponses);
    }
}
