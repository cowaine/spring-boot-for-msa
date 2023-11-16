package com.cowaine.corock.chapter07.service;

import com.cowaine.corock.chapter07.aspect.ElapseLoggable;
import com.cowaine.corock.chapter07.dto.HotelRequest;
import com.cowaine.corock.chapter07.dto.HotelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelDisplayService implements DisplayService {

    @ElapseLoggable
    @Override
    public List<HotelResponse> getHotelsByName(HotelRequest hotelRequest) {
        // 로깅 로직


        // 인증/인가 로직


        // 트랜잭션 로직


        // return hotelRepository.findByName(name)
        //         .stream()
        //         .filter(...)
        //         .map(...)
        //         .collect(Collectors.toList());
        return List.of(HotelResponse.create(1_000L, "Ragged Point Inn", "18091 CA-1, San Simeon, CA 93452",
                "+18885846374"));
    }

}
