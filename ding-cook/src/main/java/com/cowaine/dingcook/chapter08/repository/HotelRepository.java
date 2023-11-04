package com.cowaine.dingcook.chapter08.repository;

import com.cowaine.dingcook.chapter08.domain.HotelEntity;
import com.cowaine.dingcook.chapter08.domain.HotelStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

    List<HotelEntity> findByStatus(HotelStatus status);

    @Query("SELECT h FROM hotels AS h WHERE h.hotelId = ?1 AND h.status = 0")
    HotelEntity findReadyOne(Long hotelId);

    @Query("SELECT h FROM hotels AS h WHERE  h.hotelId = :hotelId AND h.status = :status")
    HotelEntity findOne(@Param("hotelId") Long hotelId, @Param("status") HotelStatus status);

}
