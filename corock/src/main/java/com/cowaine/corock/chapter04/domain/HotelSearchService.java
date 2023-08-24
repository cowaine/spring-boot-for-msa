package com.cowaine.corock.chapter04.domain;

import org.springframework.stereotype.Service;

@Service
public class HotelSearchService {

    public Hotel getHotelById(final Long id) {
        return Hotel.newInstance(id, "The Continental", "1 Wall St, New York, NY 10005", 250);
    }

}
