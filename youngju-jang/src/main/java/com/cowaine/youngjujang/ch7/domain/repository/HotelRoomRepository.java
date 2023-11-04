package com.cowaine.youngjujang.ch7.domain.repository;

import com.cowaine.youngjujang.ch7.domain.entity.HotelRoomEntity;
import org.springframework.stereotype.Repository;

@Repository
public class HotelRoomRepository {
     public HotelRoomEntity findById(Long id){
          return new HotelRoomEntity(id, "EAST-1902", 19, 2, 1);
     }
}
