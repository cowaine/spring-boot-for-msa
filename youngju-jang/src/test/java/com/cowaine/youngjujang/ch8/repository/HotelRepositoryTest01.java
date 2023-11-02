package com.cowaine.youngjujang.ch8.repository;

import com.cowaine.youngjujang.ch8.domain.HotelEntity;
import com.cowaine.youngjujang.ch8.domain.HotelStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(properties = {"spring.config.location = classpath:application-test-h2.yaml"})
public class HotelRepositoryTest01 {
     
     private static HotelEntity testHotelEntity;
     
     @Autowired
     private HotelRepository hotelRepository;
     
     @BeforeEach
     public void init(){
          testHotelEntity = HotelEntity.of("The LINE LA", "3515 Wilshire Blvd, Los Angelus, CA 90010", "+12133817411", 100);
     }
     
     @Test
     public void testFindByStatus(){
          // Given
          hotelRepository.save(testHotelEntity);
          
          // When
          HotelEntity hotelEntity = hotelRepository.findByStatus(HotelStatus.READY)
               .stream()
               .filter(entity -> entity.getHotelId().equals(testHotelEntity.getHotelId()))
               .findFirst()
               .get();
          
          // Then
          Assertions.assertNotNull(hotelEntity);
          Assertions.assertEquals(testHotelEntity.getAddress(), hotelEntity.getAddress());
          Assertions.assertEquals(testHotelEntity.getName(), hotelEntity.getName());
          Assertions.assertEquals(testHotelEntity.getPhoneNumber(), hotelEntity.getPhoneNumber());
     }
}
