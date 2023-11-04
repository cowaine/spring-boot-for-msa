package com.cowaine.corock.chapter07.service;

import com.cowaine.corock.chapter07.dto.HotelRequest;
import com.cowaine.corock.chapter07.dto.HotelResponse;

import java.util.List;

public interface DisplayService {

    List<HotelResponse> getHotelsByName(HotelRequest hotelRequest);

}
