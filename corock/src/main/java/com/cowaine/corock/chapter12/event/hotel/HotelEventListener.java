package com.cowaine.corock.chapter12.event.hotel;

import com.cowaine.corock.chapter12.service.PropagationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class HotelEventListener {

    private final PropagationService propagationService;

    @Async
    @Order(1)
    @TransactionalEventListener(classes = HotelCreateEvent.class, fallbackExecution = true)
    public void handleHotelCreateEvent(HotelCreateEvent hotelCreateEvent) {
        log.info("handle HotelCreatedEvent: {}", hotelCreateEvent);
        propagationService.propagateHotelEvent();
    }

    @Async
    @Order(2)
    @TransactionalEventListener(classes = HotelCreateEvent.class)
    public void handleResourceCreateEvent(HotelCreateEvent hotelCreateEvent) {
        log.info("handle resourceCreatedEvent: {}", hotelCreateEvent);
        propagationService.propagateResourceEvent();
    }

}
