package com.cowaine.corock.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
public class ReservationController {

    @GetMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}/reservations")
    public List<Long> getReservationsByPaging(@PathVariable final Long hotelId, @PathVariable final String roomNumber,
                                              Pageable pageable) {

        log.info("Page param: {}", pageable.getPageNumber());
        log.info("Size param: {}", pageable.getPageSize());
        pageable.getSort()
                .stream()
                .forEach(order -> log.info("Sort param: {}", order.getProperty() + ": " + order.getDirection()));

        return Collections.emptyList();
    }

}
