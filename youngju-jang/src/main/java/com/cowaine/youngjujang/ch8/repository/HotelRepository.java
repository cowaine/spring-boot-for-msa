package com.cowaine.youngjujang.ch8.repository;

import com.cowaine.youngjujang.ch8.domain.HotelStatus;
import com.cowaine.youngjujang.ch8.domain.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> { // Long : 기본키 클래스타입
     List<HotelEntity> findByStatus(HotelStatus status);
}
