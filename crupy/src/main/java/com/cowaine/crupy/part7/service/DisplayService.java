package com.cowaine.crupy.part7.service;

import com.cowaine.crupy.part7.controller.HotelRequest;
import com.cowaine.crupy.part7.controller.HotelResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DisplayService {
    List<HotelResponse> getHotelsByName(HotelRequest hotelRequest);
}
