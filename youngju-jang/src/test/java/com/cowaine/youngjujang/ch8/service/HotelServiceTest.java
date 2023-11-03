package com.cowaine.youngjujang.ch8.service;

import com.cowaine.youngjujang.ch8.controller.HotelCreateRequest;
import com.cowaine.youngjujang.ch8.controller.HotelCreateResponse;
import com.cowaine.youngjujang.ch8.domain.HotelEntity;
import com.cowaine.youngjujang.ch8.repository.HotelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional // 테스트 후 되돌림
@SpringBootTest
@TestPropertySource (properties = {"spring.config.location = classpath:application-test.yaml"})
class HotelServiceTest {
     
     @Autowired
     private HotelService hotelService;
     
     @Autowired
     private HotelRepository hotelRepository;
     
     @Test
     public void testCreateHotel(){
          // Given  만들려는 호텔
          HotelCreateRequest request = new HotelCreateRequest();
          request.setName("test");
          request.setAddress("test Address");
          request.setPhoneNumber("010-3823-5151");
//          request.setRoomCount(10);
          
          // When
          HotelCreateResponse response = hotelService.createHotel(request);
          HotelEntity hotelEntity = hotelRepository.findById(response.getHotelId()).orElse(null); // 만든 호텔
          
          // Then
          Assertions.assertNotNull(hotelEntity);
          Assertions.assertEquals(request.getName(), hotelEntity.getName());
          Assertions.assertEquals(request.getAddress(), hotelEntity.getAddress());
          Assertions.assertEquals(request.getPhoneNumber(), hotelEntity.getPhoneNumber());
//          Assertions.assertEquals(request.getRoomCount(), hotelEntity.getRoomCount());
     }
}