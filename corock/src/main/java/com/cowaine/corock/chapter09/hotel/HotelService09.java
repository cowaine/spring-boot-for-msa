package com.cowaine.corock.chapter09.hotel;

import com.cowaine.corock.chapter08.controller.HotelCreateRequest;
import com.cowaine.corock.chapter08.controller.HotelCreateResponse;
import com.cowaine.corock.chapter08.domain.HotelEntity;
import com.cowaine.corock.chapter08.domain.HotelRoomEntity;
import com.cowaine.corock.chapter08.domain.HotelRoomType;
import com.cowaine.corock.chapter08.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class HotelService09 {

    private final HotelRepository hotelRepository;
    // private final BillingApiAdaptor billingApiAdaptor;

    @Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
    public HotelCreateResponse createHotel(HotelCreateRequest createRequest) {
        HotelEntity hotelEntity = HotelEntity.of(createRequest.getName(), createRequest.getAddress(),
                createRequest.getPhoneNumber());

        int roomCount = createRequest.getRoomCount();
        List<HotelRoomEntity> hotelRoomEntities = IntStream.range(0, roomCount)
                .mapToObj(i -> HotelRoomEntity.of("ROOM-" + i, HotelRoomType.DOUBLE, BigDecimal.valueOf(100)))
                .collect(Collectors.toList());
        hotelEntity.addHotelRooms(hotelRoomEntities);

        HotelEntity savedHotelEntity = hotelRepository.save(hotelEntity);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                // billingApiAdaptor.registerHotelCode(hotelEntity.getHotelId());
            }
        });

        return HotelCreateResponse.of(hotelEntity.getHotelId());
    }

}
