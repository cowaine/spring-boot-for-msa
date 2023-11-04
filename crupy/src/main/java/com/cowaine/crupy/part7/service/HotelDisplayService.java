package com.cowaine.crupy.part7.service;

import com.cowaine.crupy.part7.aspect.ElapseLoggable;
import com.cowaine.crupy.part7.controller.HotelRequest;
import com.cowaine.crupy.part7.controller.HotelResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class HotelDisplayService implements DisplayService {

    @Override
    @ElapseLoggable
    public List<HotelResponse> getHotelsByName(HotelRequest hotelRequest) {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.error("error", e);
        }

        return List.of(
                new HotelResponse(1000L,
                        "Ragged Point Inn",
                        "18091 CA-1, San Simeon, CA 93452",
                        "+18885846374"
                )
        );
    }
}