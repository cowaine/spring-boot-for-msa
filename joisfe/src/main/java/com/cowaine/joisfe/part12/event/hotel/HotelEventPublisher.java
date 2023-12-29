package com.cowaine.joisfe.part12.event.hotel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class HotelEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishHotelCreated(Long hotelId, String address) {
        HotelCreateEvent event = HotelCreateEvent.of(hotelId, address);
        log.info("Publish hotel created event.");
        applicationEventPublisher.publishEvent(event);
    }

}
