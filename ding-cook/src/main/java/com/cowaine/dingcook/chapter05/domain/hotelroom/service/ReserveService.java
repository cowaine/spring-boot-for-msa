package com.cowaine.dingcook.chapter05.domain.hotelroom.service;

import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class ReserveService implements HotelRoomReserveService {

    @Override
    public Long reserveHotelRoom(Long hotelId, String roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        // sudo code. Example
//        hotelRoomRepository.findByHotelIdAndRoomNumber(hotelId, roomNumber)
//                .orElseThrow(() -> {
//                    log.error("Invalid roomNumber. hotelId:{}, roomNumber:{}", hotelId, roomNumber);
//                    return new BadRequestException("Not existing roomNumber");
//                });

        return 1_002_003_004L;
    }
}
