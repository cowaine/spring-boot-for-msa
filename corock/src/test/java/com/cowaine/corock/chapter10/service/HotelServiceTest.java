package com.cowaine.corock.chapter10.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelServiceTest {

    @Autowired
    HotelService hotelService;

    @Test
    void testGetHotelById() {
        hotelService.getHotelById(1L);
    }

    @Test
    void testGetHotelNameAndAddress() {
        hotelService.getHotelNameAndAddress("testHotelName", "testHotelAddress");
    }

    @Test
    void testGetHotel() {
        HotelRequest request = new HotelRequest(123_123L);
        hotelService.getHotel(request);
    }

}
