package com.cowaine.dingcook.chapter08.repository;

import com.cowaine.dingcook.chapter08.domain.HotelEntity;
import com.cowaine.dingcook.chapter08.domain.HotelStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

    List<HotelEntity> findByStatus(HotelStatus status);

}
