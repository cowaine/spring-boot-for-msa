package com.cowaine.corock.chapter07.repository;

import com.cowaine.corock.chapter07.domain.HotelRoomEntity;
import org.springframework.stereotype.Repository;

/**
 * 스프링 프레임워크에서 제공하는 {@link Repository} 애너테이션은 데이터베이스에 데이터를 생성, 삭제, 수정, 조회하는 기능을 제공하는 클래스를 스프링 빈으로 정의할 때 사용한다.
 */
@Repository
public class HotelRoomRepository {

    public HotelRoomEntity findById(Long id) {
        return new HotelRoomEntity(id, "EAST-1902", 19, 2, 1);
    }

}
