package com.cowaine.youngjujang.ch7.domain.service;

import com.cowaine.youngjujang.ch7.domain.controller.HotelRequest;
import com.cowaine.youngjujang.ch7.domain.controller.HotelResponse;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
class HotelDisplayServiceTest {

     private final HotelDisplayService hotelDisplayService;
     private final ApplicationContext applicationContext;
     
     @Autowired // 생성자주입방식으로 하려면 생성자에 Autowired필수
     public HotelDisplayServiceTest(HotelDisplayService hotelDisplayService,
                                    ApplicationContext applicationContext) {
          this.hotelDisplayService = hotelDisplayService;
          this.applicationContext = applicationContext;
     }
     
     @Test
     public void testReturnOneHotelWhenRequestIsHotelName(){
          // Given
          HotelRequest hotelRequest = new HotelRequest("Line Hotel");
          
          // When
          List<HotelResponse> hotelResponses = hotelDisplayService.getHotelsByName(hotelRequest);
          
          // Then
          Assertions.assertNotNull(hotelResponses);
          Assertions.assertEquals(1, hotelResponses.size());
     }
     
     @Test
     public void testApplicationContext(){
          // 스프링빈 받아오는 방법
          HotelDisplayService displayService = applicationContext.getBean(HotelDisplayService.class);
          
          Assertions.assertNotNull(displayService);
          Assertions.assertTrue(displayService instanceof HotelDisplayService);
     }
}