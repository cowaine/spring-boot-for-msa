package com.cowaine.dingcook.chapter08.service;

import com.cowaine.dingcook.chapter08.controller.HotelCreateRequest;
import com.cowaine.dingcook.chapter08.controller.HotelCreateResponse;
import com.cowaine.dingcook.chapter08.controller.HotelResponse;
import com.cowaine.dingcook.chapter08.domain.HotelEntity;
import com.cowaine.dingcook.chapter08.domain.HotelRoomEntity;
import com.cowaine.dingcook.chapter08.domain.HotelRoomType;
import com.cowaine.dingcook.chapter08.repository.HotelRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

//@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional(readOnly = true)
    public HotelResponse getHotelById(Long hotelId) {

        return hotelRepository.findById(hotelId)
                              .map(HotelResponse::of)
                              .orElse(HotelResponse.EMPTY);
    }

    @Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
    public HotelCreateResponse createHotel(HotelCreateRequest createRequest) {
        HotelEntity hotelEntity = HotelEntity.of(
            createRequest.getName(),
            createRequest.getAddress(),
            createRequest.getPhoneNumber());

        int roomCount = createRequest.getRoomCount();
        List<HotelRoomEntity> hotelRoomEntities = IntStream.range(0, roomCount)
                                                           .mapToObj(i -> HotelRoomEntity.of("ROOM-" + i,
                                                               HotelRoomType.DOUBLE, BigDecimal.valueOf(100)))
                                                           .collect(Collectors.toList());
        hotelEntity.addHotelRooms(hotelRoomEntities);

        hotelRepository.save(hotelEntity);
        return HotelCreateResponse.of(hotelEntity.getHotelId());
    }

}
