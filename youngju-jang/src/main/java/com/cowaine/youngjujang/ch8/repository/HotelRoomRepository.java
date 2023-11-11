package com.cowaine.youngjujang.ch8.repository;

import com.cowaine.youngjujang.ch8.domain.HotelRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRoomRepository extends JpaRepository<HotelRoomEntity, Long> {
     List<HotelRoomEntity> findByHotelId(Long hotelId);
}
