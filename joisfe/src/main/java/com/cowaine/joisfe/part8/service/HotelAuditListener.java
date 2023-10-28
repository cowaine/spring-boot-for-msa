package com.cowaine.joisfe.part8.service;

import com.cowaine.joisfe.part8.domain.HotelEntity;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HotelAuditListener {

    @PostPersist
    public void logWhenCreated(HotelEntity hotelEntity) {
        log.info("hotel created. id:{}", hotelEntity.getHotelId());
    }

    @PostUpdate
    @PostRemove
    public void logWhenChanged(HotelEntity hotelEntity) {
        log.info("hotel changed. id:{}, name:{}", hotelEntity.getHotelId(), hotelEntity.getName());
    }
}