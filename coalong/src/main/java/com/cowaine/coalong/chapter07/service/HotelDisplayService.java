package com.cowaine.coalong.chapter07.service;

import com.cowaine.coalong.chapter07.aspect.ElapseLoggable;
import com.cowaine.coalong.chapter07.dto.HotelRequest;
import com.cowaine.coalong.chapter07.dto.HotelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelDisplayService implements DisplayService {
    @Override
    @ElapseLoggable
    public List<HotelResponse> getHotelsByName(HotelRequest hotelRequest) {
        return List.of(new HotelResponse(1));
    }
}
