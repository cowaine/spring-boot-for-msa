package com.cowaine.youngjujang.ch5.domain.repository;

import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomResponse;
import com.cowaine.youngjujang.ch5.domain.model.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {
     Optional<HotelRoom> findByIdAndRoomNumber(Long hotelId, String roomNumber);
}
