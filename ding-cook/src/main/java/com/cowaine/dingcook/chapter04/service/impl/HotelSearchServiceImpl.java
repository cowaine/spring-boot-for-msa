package com.cowaine.dingcook.domain.chapter04.service.impl;

import com.cowaine.dingcook.domain.chapter04.entity.Hotel;
import com.cowaine.dingcook.domain.chapter04.service.HotelSearchService;
import org.springframework.stereotype.Service;

@Service
public class HotelSearchServiceImpl implements HotelSearchService {

    @Override
    public Hotel getHotelById(Long hotelId) {
        return new Hotel(hotelId,
            "The Continental",
            "1 Wall St, New York, NY 10005",
            250);
    }
}
