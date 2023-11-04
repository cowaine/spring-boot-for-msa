package com.cowaine.joisfe.part7.service;

import com.cowaine.joisfe.part7.dto.HotelRoomResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HotelRoomDisplayServiceTest00 {

    @Autowired
    private HotelRoomDisplayService hotelRoomDisplayService;

    @Test
    public void testOriginal() {
        HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(1L);

        Assertions.assertNotNull(hotelRoomResponse);
        Assertions.assertEquals(1L, hotelRoomResponse.getHotelRoomId());
    }

}
