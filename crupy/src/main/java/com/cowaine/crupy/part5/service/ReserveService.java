package com.cowaine.crupy.part5.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReserveService {

    public Long reserveHotelRoom(Long hotelId, String roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {

        hotelRoomRepository.findByHotelIdAndRoomNumber(hotelId, roomNumber)
                .orElseThrow(() -> {
                    log.error("Invalid roomNumber. HotelId:{}, roomNumber:{}", hotelId, roomNumber);

                    return new BadRequestException("Not existing roomNumber");
                });
    }
}

