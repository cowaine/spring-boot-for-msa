package com.cowaine.dingcook.chapter08.repository;

import com.cowaine.dingcook.chapter08.domain.HotelRoomEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoomEntity, Long> {

    List<HotelRoomEntity> findByHotelId(Long hotelId);

}
