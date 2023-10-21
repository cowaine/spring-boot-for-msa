package com.cowaine.ahngilwoong.chapter7.service.spec;


import com.cowaine.ahngilwoong.chapter7.model.HotelRequest;
import com.cowaine.ahngilwoong.chapter7.model.HotelResponse;
import java.util.List;

public interface DisplayService {

    List<HotelResponse> getHotelsByName();
}
