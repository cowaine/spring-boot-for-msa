package com.cowaine.joisfe.part12.service;

import com.cowaine.joisfe.part12.event.hotel.HotelEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HotelService {

    private final HotelEventPublisher hotelEventPublisher;

    public Boolean createHotel(String hotelName, String hotelAddress) {
        // 호텔 생성 로직 생략
        log.info("created hotel. {}, {}", hotelName, hotelAddress);
        hotelEventPublisher.publishHotelCreated(999111222L, hotelAddress);
        log.info("done create hotel");
        return Boolean.TRUE;
    }
}
