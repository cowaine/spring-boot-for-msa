package com.cowaine.corock.chapter07.service;

import com.cowaine.corock.chapter07.domain.HotelRoomEntity;
import com.cowaine.corock.chapter07.dto.HotelRoomResponse;
import com.cowaine.corock.chapter07.repository.HotelRoomRepository;
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

    public HotelRoomResponse getHotelRoomById(Long id) {
        HotelRoomEntity hotelRoom = hotelRoomRepository.findById(id);
        threadPoolTaskExecutor.execute(() -> log.warn("entity: {}", hotelRoom));

        return HotelRoomResponse.from(hotelRoom);
    }

}
