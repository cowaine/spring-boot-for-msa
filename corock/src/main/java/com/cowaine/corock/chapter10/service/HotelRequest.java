package com.cowaine.corock.chapter10.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.cache.annotation.Cacheable;

@AllArgsConstructor
@Getter
@ToString
@Cacheable
public class HotelRequest {

    private Long hotelId;

}
