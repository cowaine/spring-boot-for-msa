package com.cowaine.corock.chapter12.event.hotel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class HotelEventListener {

    @Async
    @Order(1)
    @TransactionalEventListener(classes = HotelCreateEvent.class, fallbackExecution = true)
    public void handleHotelCreateEvent(HotelCreateEvent hotelCreateEvent) {
        log.info("handle HotelCreatedEvent: {}", hotelCreateEvent);
    }

    @Async
    @Order(2)
    @TransactionalEventListener(classes = HotelCreateEvent.class)
    public void handleResourceCreateEvent(HotelCreateEvent hotelCreateEvent) {
        log.info("handle resourceCreatedEvent: {}", hotelCreateEvent);
    }

}
