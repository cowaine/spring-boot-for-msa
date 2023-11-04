package com.cowaine.youngjujang.ch7.domain.service;

import com.cowaine.youngjujang.ch7.domain.controller.HotelRoomResponse;
import com.cowaine.youngjujang.ch7.domain.entity.HotelRoomEntity;
import com.cowaine.youngjujang.ch7.domain.repository.HotelRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelRoomDisplayService {
     
     private final HotelRoomRepository hotelRoomRepository;
     private final ThreadPoolTaskExecutor threadPoolTaskExecutor;
     
     // restApi entity 연동된 response
     public HotelRoomResponse getHotelRoomById(Long id){
          HotelRoomEntity hotelRoomEntity = hotelRoomRepository.findById(id);
          threadPoolTaskExecutor.execute(() -> log.warn("entity :{}", hotelRoomEntity.toString()));
          return HotelRoomResponse.from(hotelRoomEntity);
     }
}
