package com.cowaine.ahngilwoong.chapter8.service;

import com.cowaine.ahngilwoong.chapter8.domain.HotelEntity;
import com.cowaine.ahngilwoong.chapter8.domain.HotelRoomEntity;
import com.cowaine.ahngilwoong.chapter8.model.HotelCreateRequest;
import com.cowaine.ahngilwoong.chapter8.model.HotelCreateResponse;
import com.cowaine.ahngilwoong.chapter8.model.HotelResponse;
import com.cowaine.ahngilwoong.chapter8.enums.HotelRoomType;
import com.cowaine.ahngilwoong.chapter8.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
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
            .mapToObj(i -> HotelRoomEntity.of("ROOM-" + i, HotelRoomType.DOUBLE, BigDecimal.valueOf(100)))
            .collect(Collectors.toList());
        hotelEntity.addHotelRooms(hotelRoomEntities);

        hotelRepository.save(hotelEntity);
        return HotelCreateResponse.of(hotelEntity.getHotelId());
    }

}
