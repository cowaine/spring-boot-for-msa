package com.cowaine.corock.chapter12.event.hotel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HotelEventListener {

    @Async
    @Order(1)
    @EventListener(classes = HotelCreateEvent.class)
    public void handleHotelCreateEvent(HotelCreateEvent hotelCreateEvent) {
        log.info("handle HotelCreatedEvent: {}", hotelCreateEvent);
    }

    @Async
    @Order(2)
    @EventListener(classes = HotelCreateEvent.class)
    public void handleResourceCreateEvent(HotelCreateEvent hotelCreateEvent) {
        log.info("handle resourceCreatedEvent: {}", hotelCreateEvent);
    }

}
