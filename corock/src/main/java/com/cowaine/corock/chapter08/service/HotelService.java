package com.cowaine.corock.chapter08.service;

import com.cowaine.corock.chapter05.HotelRoomType;
import com.cowaine.corock.chapter08.controller.HotelCreateRequest;
import com.cowaine.corock.chapter08.controller.HotelCreateResponse;
import com.cowaine.corock.chapter08.domain.HotelEntity;
import com.cowaine.corock.chapter08.domain.HotelRoomEntity;
import com.cowaine.corock.chapter08.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    @Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
    public HotelCreateResponse createHotel(HotelCreateRequest createRequest) {
        HotelEntity hotelEntity = HotelEntity.of(createRequest.getName(), createRequest.getAddress(),
                                                 createRequest.getPhoneNumber());

        int roomCount = createRequest.getRoomCount();
        List<HotelRoomEntity> hotelRoomEntities = IntStream.range(0, roomCount)
                .mapToObj(i -> HotelRoomEntity.of("ROOM-" + i, HotelRoomType.DOUBLE, BigDecimal.valueOf(100)))
                .collect(Collectors.toList());
        hotelEntity.addHotelRooms(hotelRoomEntities);

        hotelRepository.save(hotelEntity);

        return HotelCreateResponse.of(hotelEntity.getHotelId());
    }

}
