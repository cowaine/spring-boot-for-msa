package com.cowaine.ahngilwoong.chapter10.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.cache.annotation.Cacheable;

@Getter
@ToString
@Cacheable
public class HotelRequest {
    private Long hotelId;

    public HotelRequest(Long hotelId) {
        this.hotelId = hotelId;
    }
}