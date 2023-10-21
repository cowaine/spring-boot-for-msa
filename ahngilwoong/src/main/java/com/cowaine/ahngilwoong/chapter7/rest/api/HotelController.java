package com.cowaine.ahngilwoong.chapter7.rest.api;

import com.cowaine.ahngilwoong.chapter7.model.HotelRequest;
import com.cowaine.ahngilwoong.chapter7.model.HotelResponse;
import com.cowaine.ahngilwoong.chapter7.service.HotelDisplayService;
import com.cowaine.ahngilwoong.chapter7.service.spec.DisplayService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HotelController {
    private final DisplayService displayService;
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/hotels/fetch-by-name")
    public ResponseEntity<List<HotelResponse>> getHotelByName(@RequestBody HotelRequest hotelRequest) {
        List<HotelResponse> hotelResponses = displayService.getHotelsByName(hotelRequest);
        return ResponseEntity.ok(hotelResponses);
    }
}
