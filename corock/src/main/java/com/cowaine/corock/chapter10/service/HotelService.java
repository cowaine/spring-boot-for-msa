package com.cowaine.corock.chapter10.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Cacheable(cacheNames = "hotelCache")
    public HotelResponse getHotelById(Long hotelId) {
        return HotelResponse.create(hotelId, "Line Hotel", "3515 Wilshire Blvd, Los Angeles, CA 90010");
    }

    @Cacheable(cacheNames = "hotelCache", key = "#hotelName", condition = "#hotelName > '' && #hotelAddress.length() > 10")
    public HotelResponse getHotelNameAndAddress(String hotelName, String hotelAddress) {
        return HotelResponse.create(234_234L, hotelName, hotelAddress);
    }

    @Cacheable(cacheNames = "hotelCache", keyGenerator = "hotelKeyGenerator")
    public HotelResponse getHotel(HotelRequest hotelRequest) {
        return HotelResponse.create(hotelRequest.getHotelId(), "The shilla", "249, Dongho-ro, Jung-gu, Seoul");
    }

}
