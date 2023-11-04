package com.cowaine.coalong.chapter08.repository;

import com.cowaine.coalong.chapter08.domain.HotelEntity;
import com.cowaine.coalong.chapter08.domain.HotelStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    Optional<HotelEntity> findById(Long id);

    List<HotelEntity> findByStatus(HotelStatus hotelStatus);

}



