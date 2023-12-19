package com.cowaine.corock.chapter12.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PropagationService {

    public void propagateHotelEvent() {
        log.info("propagation of hotel event");
    }

    public void propagateResourceEvent() {
        log.info("propagation of resource event");
    }

}
