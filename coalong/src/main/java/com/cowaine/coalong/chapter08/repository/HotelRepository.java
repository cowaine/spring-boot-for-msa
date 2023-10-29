package com.cowaine.coalong.chapter08.repository;

import com.cowaine.coalong.chapter08.domain.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    Optional<HotelEntity> findById(Long id);

}