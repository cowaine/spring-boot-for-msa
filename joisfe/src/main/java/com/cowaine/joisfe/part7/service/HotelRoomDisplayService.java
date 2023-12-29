package com.cowaine.joisfe.part7.service;

import com.cowaine.joisfe.part7.domain.HotelRoomEntity;
import com.cowaine.joisfe.part7.dto.HotelRoomResponse;
import com.cowaine.joisfe.part7.repository.HotelRoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @author : 조재철
 * @since 1.0
 */
@Slf4j
//@Service
public class HotelRoomDisplayService {

    private final HotelRoomRepository hotelRoomRepository;
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public HotelRoomDisplayService(HotelRoomRepository hotelRoomRepository,
        ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.hotelRoomRepository = hotelRoomRepository;
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    public HotelRoomResponse getHotelRoomById(Long id) {
        HotelRoomEntity hotelRoomEntity = hotelRoomRepository.findById(id);
        threadPoolTaskExecutor.execute(() -> log.warn("entity :{}", hotelRoomEntity.toString()));
        return HotelRoomResponse.from(hotelRoomEntity);
    }
}
