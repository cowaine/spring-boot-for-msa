package com.cowaine.joisfe.part7.repository;

import com.cowaine.joisfe.part7.domain.HotelRoomEntity;
import org.springframework.stereotype.Repository;

/**
 * @author : 조재철
 * @since 1.0
 */
//@Repository
public class HotelRoomRepository {

    public HotelRoomEntity findById(Long id) {
        return new HotelRoomEntity(id, "EAST-1902", 19, 2, 1);
    }
}
