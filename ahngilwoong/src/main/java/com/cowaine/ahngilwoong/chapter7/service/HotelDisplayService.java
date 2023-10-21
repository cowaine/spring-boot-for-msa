package com.cowaine.ahngilwoong.chapter7.service;

import com.cowaine.ahngilwoong.chapter7.aop.ElapseLoggable;
import com.cowaine.ahngilwoong.chapter7.model.HotelRequest;
import com.cowaine.ahngilwoong.chapter7.model.HotelResponse;
import com.cowaine.ahngilwoong.chapter7.service.spec.DisplayService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class HotelDisplayService implements DisplayService {

    @Override
    @ElapseLoggable
    public List<HotelResponse> getHotelsByName() {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.error("error", e);
        }

        return List.of(
            new HotelResponse(1000L,
                "Gyung Ju Ra Han Hotel",
                "South Korea GyungJu",
                "+82 10 8387 3371"
            )
        );
    }
}
