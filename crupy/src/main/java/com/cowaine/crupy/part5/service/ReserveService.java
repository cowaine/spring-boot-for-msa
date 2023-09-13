package com.cowaine.crupy.part5.service;

import com.cowaine.crupy.part5.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface ReserveService {
    Long reserveHotelRoom(Long hotelId, String roomNumber, LocalDate checkInDate, LocalDate checkOutDate);
}

