package com.cowaine.joisfe.part4.domain;

import org.springframework.stereotype.Service;

@Service
public class HotelSearchService {

    public Hotel getHotelById(Long hotelId) {
        return new Hotel(hotelId,
            "코티야드",
            "판교역 근처",
            250);
    }
}
