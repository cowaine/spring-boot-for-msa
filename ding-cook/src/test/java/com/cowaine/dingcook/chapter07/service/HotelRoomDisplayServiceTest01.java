package com.cowaine.dingcook.chapter07.service;

import com.cowaine.dingcook.chapter07.config.ThreadPoolTestConfig;
import com.cowaine.dingcook.chapter07.controller.HotelRoomResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
//@Import(value = {ThreadPoolTestConfig.class})
@ContextConfiguration(classes = ThreadPoolTestConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class HotelRoomDisplayServiceTest01 {

    @Autowired
    private HotelRoomDisplayService hotelRoomDisplayService;

    @Test
    public void testTestConfiguration() {
        HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(1L);

        Assertions.assertNotNull(hotelRoomResponse);
        Assertions.assertEquals(1L, hotelRoomResponse.getHotelRoomId());
    }
}
