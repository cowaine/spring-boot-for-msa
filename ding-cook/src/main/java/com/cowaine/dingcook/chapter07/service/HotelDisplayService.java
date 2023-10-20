package com.cowaine.dingcook.chapter07.service;

import com.cowaine.dingcook.chapter07.aspect.ElapseLoggable;
import com.cowaine.dingcook.chapter07.controller.HotelRequest;
import com.cowaine.dingcook.chapter07.controller.HotelResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
