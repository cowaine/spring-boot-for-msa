package com.cowaine.ahngilwoong.chapter8.repository;

import com.cowaine.ahngilwoong.chapter8.domain.HotelRoomEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoomEntity, Long> {

    List<HotelRoomEntity> findByHotelId(Long hotelId);

}

