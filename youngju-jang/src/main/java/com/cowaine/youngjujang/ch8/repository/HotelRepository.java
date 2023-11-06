package com.cowaine.youngjujang.ch8.repository;

import com.cowaine.youngjujang.ch8.domain.HotelStatus;
import com.cowaine.youngjujang.ch8.domain.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> { // Long : 기본키 클래스타입
     List<HotelEntity> findByStatus(HotelStatus status);
     
     // HotelEntity 에 @Entity(name = "hotels") 설정필요
     @Query("SELECT h FROM hotels AS h WHERE h.hotelId = ?1 AND h.status = 0")
     HotelEntity findReadyOne(Long hotelId);
     
     @Query("SELECT h FROM hotels AS h where h.hotelId = :hotelId AND h.status = :status")
     HotelEntity findOne(@Param("hotelId") Long hotelId, @Param("status") HotelStatus status);
}
