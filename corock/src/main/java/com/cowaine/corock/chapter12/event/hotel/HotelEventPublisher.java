package com.cowaine.corock.chapter12.event.hotel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HotelEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishHotelCreated(Long hotelId, String address) {
        HotelCreateEvent event = HotelCreateEvent.of(hotelId, address);
        log.info("Publish hotel created event.");
        applicationEventPublisher.publishEvent(event);
    }

}
