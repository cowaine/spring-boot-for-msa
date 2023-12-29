package com.cowaine.dingcook.chapter07.service;

import com.cowaine.dingcook.chapter07.controller.HotelRoomResponse;
import com.cowaine.dingcook.chapter07.domain.HotelRoomEntity;
import com.cowaine.dingcook.chapter07.repository.HotelRoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HotelRoomDisplayService {

    private final HotelRoomRepository hotelRoomRepository;
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public HotelRoomDisplayService(HotelRoomRepository hotelRoomRepository,
                                   ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.hotelRoomRepository = hotelRoomRepository;
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

//    public HotelRoomResponse getHotelRoomById(Long id) {
//        HotelRoomEntity hotelRoomEntity = hotelRoomRepository.findById(id);
//        threadPoolTaskExecutor.execute(() -> log.warn("entity :{}", hotelRoomEntity.toString()));
//        return HotelRoomResponse.from(hotelRoomEntity);
//    }
}
