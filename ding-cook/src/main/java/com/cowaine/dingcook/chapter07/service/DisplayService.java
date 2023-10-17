package com.cowaine.dingcook.chapter07.service;

import com.cowaine.dingcook.chapter07.controller.HotelRequest;
import com.cowaine.dingcook.chapter07.controller.HotelResponse;
import java.util.List;

public interface DisplayService {

    List<HotelResponse> getHotelsByName(HotelRequest hotelRequest);
}
