package com.cowaine.joisfe.part7.service;

import com.cowaine.joisfe.part7.aspect.ElapseLoggable;
import com.cowaine.joisfe.part7.dto.HotelRequest;
import com.cowaine.joisfe.part7.dto.HotelResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : 조재철
 * @since 1.0
 */
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
                "아난티 기장",
                "부산광역시 기장 어딘가..",
                "010-****-****"
            )
        );
    }
}
