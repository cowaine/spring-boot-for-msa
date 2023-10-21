package com.cowaine.joisfe.part7.service;

import com.cowaine.joisfe.part7.dto.HotelRequest;
import com.cowaine.joisfe.part7.dto.HotelResponse;
import java.util.List;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface DisplayService {

    List<HotelResponse> getHotelsByName(HotelRequest hotelRequest);
}
