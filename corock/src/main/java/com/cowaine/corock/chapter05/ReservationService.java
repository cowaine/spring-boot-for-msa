package com.cowaine.corock.chapter05;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {

    public Long reserveHotelRoom(Long hotelId, String roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        return 1_002_003_004L;
    }

}
