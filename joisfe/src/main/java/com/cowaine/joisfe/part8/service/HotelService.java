package com.cowaine.joisfe.part8.service;

import com.cowaine.joisfe.part8.domain.HotelEntity;
import com.cowaine.joisfe.part8.dto.HotelCreateRequestDto;
import com.cowaine.joisfe.part8.dto.HotelCreateResponseDto;
import com.cowaine.joisfe.part8.dto.HotelResponseDto;
import com.cowaine.joisfe.part8.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional(readOnly = true)
    public HotelResponseDto getHotelById(Long hotelId) {

        return hotelRepository.findById(hotelId)
                              .map(HotelResponseDto::of)
                              .orElse(HotelResponseDto.EMPTY);
    }

    @Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
    public HotelCreateResponseDto createHotel(HotelCreateRequestDto createRequest) {
        HotelEntity hotelEntity = HotelEntity.of(
            createRequest.getName(),
            createRequest.getAddress(),
            createRequest.getPhoneNumber());

        int roomCount = createRequest.getRoomCount();
//        List<HotelRoomEntity> hotelRoomEntities = IntStream.range(0, roomCount)
//                                                           .mapToObj(i -> HotelRoomEntity.of("ROOM-" + i, HotelRoomType.DOUBLE, BigDecimal.valueOf(100)))
//                                                           .collect(Collectors.toList());
//        hotelEntity.addHotelRooms(hotelRoomEntities);

        hotelRepository.save(hotelEntity);
        return HotelCreateResponseDto.of(hotelEntity.getHotelId());
    }

}