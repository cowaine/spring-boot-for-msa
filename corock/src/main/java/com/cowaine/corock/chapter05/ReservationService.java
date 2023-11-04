package com.cowaine.corock.chapter05;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {

    public Long reserveHotelRoom(Long hotelId, String roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        // hotelRoomRepository.findByHotelIdAndRoomNumber(hotelId, roomNumber)
        //         .orElseThrow(() -> {
        //             log.error("Invalid roomNumber. hotelId: {}, roomNumber: {}", hotelId, roomNumber);
        //             return new BadRequestException("Not existing roomNumber");
        //         });

        return 1_002_003_004L;
    }

}
