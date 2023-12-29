package com.cowaine.coalong.chapter08.repository;

import com.cowaine.coalong.chapter08.domain.HotelEntity;
import com.cowaine.coalong.chapter08.domain.HotelStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    Optional<HotelEntity> findById(Long id);

    List<HotelEntity> findByStatus(HotelStatus hotelStatus);

    @Query(value = "SELECT h FROM hotels AS h WHERE h.hotel_id = ?1 AND h.@status = 0")
    HotelEntity findReadyOne(Long hotelId);

    @Query(value = "SELECT h FROM hotels AS h WHERE h.hotel_id = :hotelId AND h.status = :status")
    HotelEntity findOne(@Param("hotelId") Long hotelId, @Param("status") HotelStatus status);

}



