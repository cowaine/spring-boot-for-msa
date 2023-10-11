package com.cowaine.youngjujang.ch7.domain.controller;

import com.cowaine.youngjujang.ch7.domain.service.ReserveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HotelController {
     private final ReserveService reserveService;
     @ResponseBody
     @RequestMapping (method = RequestMethod.POST, path = "/hotels/fetch-by-name")
     public ResponseEntity<List<HotelResponse>> getHotelsByName(@RequestBody HotelRequest hotelRequest) {
          List<HotelResponse> hotelResponses = reserveService.getHotelsByName(hotelRequest);
          return ResponseEntity.ok(hotelResponses);
     }
}
