package com.cowaine.youngjujang.ch7.domain.service;

import com.cowaine.youngjujang.ch7.domain.controller.HotelRoomResponse;
import com.cowaine.youngjujang.ch7.domain.entity.HotelRoomEntity;
import com.cowaine.youngjujang.ch7.domain.repository.HotelRoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given; // BDD(행위 주도 개발)
@SpringBootTest
public class HotelRoomDisplayServiceTest02 {
     
     @Autowired
     private HotelRoomDisplayService hotelRoomDisplayService;
     
     @MockBean // mock 객체 생성
     private HotelRoomRepository hotelRoomRepository;
     
     @Test
     public void testMockBean(){
          // BDDMockito.given() Vs Mockito.when() : BDDMockito는 bdd기반 메서드이름 제공됨 ,
          given(this.hotelRoomRepository.findById(any())) // (argumentMatchers) null제외한 type객체와 일치하는 경우
               .willReturn(new HotelRoomEntity(10L, "test", 1, 1, 1));
          
          HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(1L);
          
          Assertions.assertNotNull(hotelRoomResponse);
          Assertions.assertEquals(10L, hotelRoomResponse.getHotelRoomId());
     }
     
     @Test
     public void testAnswerMethod(){
          given(this.hotelRoomRepository.findById(any()))
               .willAnswer(new Answer<HotelRoomEntity>() { // 추상메소드 구현필요, HotelRoomEntity: answer메소드의 리턴타입
                    @Override
                    public HotelRoomEntity answer(InvocationOnMock invocation) throws Throwable {
                         // InvocationOnMock : mock객체(HotelRoomRepository)가 응답하는 메서드(findById)의 정보를 포함함
                         Long id = invocation.getArgument(0); // findById 의 첫번째 인자 리턴
                         if(id != null && id > 10){
                              return new HotelRoomEntity(id, "CODE", 10, 2, 2);
                         } else{
                              return new HotelRoomEntity(10L, "test", 1, 1, 1);
                         }
                    }
               });
          
          HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(15L);
          
          Assertions.assertNotNull(hotelRoomResponse);
          Assertions.assertEquals(15L, hotelRoomResponse.getHotelRoomId());
     }
}
