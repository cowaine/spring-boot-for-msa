package com.cowaine.corock.chapter07.service;

import com.cowaine.corock.chapter07.dto.HotelRequest;
import com.cowaine.corock.chapter07.dto.HotelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelDisplayService implements DisplayService {

    public List<HotelResponse> getHotelsByName(HotelRequest hotelRequest) {
        // 로깅 로직


        // 인증/인가 로직


        // 트랜잭션 로직


        // return hotelRepository.findByName(name)
        //         .stream()
        //         .filter(...)
        //         .map(...)
        //         .collect(Collectors.toList());
        return null;
    }

}
