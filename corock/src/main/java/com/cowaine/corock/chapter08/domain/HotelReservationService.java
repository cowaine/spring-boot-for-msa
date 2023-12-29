package com.cowaine.corock.chapter08.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HotelReservationService {

    private final RoomReserveService roomReserveService;

    /**
     * {@link org.springframework.transaction.annotation.Propagation#REQUIRED}} 속성은 {@link Transactional} 의 기본값이다.
     * 현재 진행하는 트랜잭션이 있으면 이 트랜잭션에 포함하고, 진행하는 트랜잭션이 없으면 새로운 트랜잭션을 시작한 후 해당 메서드를 실행한다.
     *
     * @param hotelId 호텔 아이디
     * @return 예약한 방 응답 객체
     */
    @Transactional
    public ReserveRoomResponse reserveRoomByHotelId(Long hotelId) {
        // (...)

        Long roomId = 1L;
        Boolean isReserved = roomReserveService.reserveRoomById(roomId);

        return new ReserveRoomResponse();
    }

}
