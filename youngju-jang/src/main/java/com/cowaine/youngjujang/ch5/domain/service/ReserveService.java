package com.cowaine.youngjujang.ch5.domain.service;

import com.cowaine.youngjujang.ch5.domain.model.HotelRoom;
import com.cowaine.youngjujang.ch5.domain.repository.HotelRoomRepository;
import com.cowaine.youngjujang.ch5.domain.utils.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReserveService {
     private final HotelRoomRepository hotelRoomRepository;
     public Long reserveHotelRoom(Long hotelId, String roomNumber, LocalDate checkInDate, LocalDate checkOutDate){
          HotelRoom hotelRoom = hotelRoomRepository.findByIdAndRoomNumber(hotelId, roomNumber)
               .orElseThrow(() -> {
                    log.error("Invalid roomNumber. hotelId:{}, roomNumber:{}", hotelId, roomNumber);
                    return new BadRequestException("Not existing roomNumber");
               });
          
          return hotelRoom.getId();
     }
}
