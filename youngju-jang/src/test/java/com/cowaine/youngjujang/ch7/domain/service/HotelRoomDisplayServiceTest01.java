package com.cowaine.youngjujang.ch7.domain.service;

import com.cowaine.youngjujang.ch7.config.TestConfig;
import com.cowaine.youngjujang.ch7.domain.controller.HotelRoomResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Import (value={TestConfig.class}
@ContextConfiguration(classes = TestConfig.class) // Import 나 이거 사용
@TestPropertySource(locations = "classpath:application-test.yaml") //
class HotelRoomDisplayServiceTest01 {

     @Autowired
     private HotelRoomDisplayService hotelRoomDisplayService;
     
     @Test
     public void testTestConfiguration(){
          HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(1L);
          
          Assertions.assertNotNull(hotelRoomResponse);
          Assertions.assertEquals(1L, hotelRoomResponse.getHotelRoomId());
     }
}