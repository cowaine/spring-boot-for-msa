package com.cowaine.dingcook.chapter05.domain.reservation.api;

import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @GetMapping("/hotels/{hotelId}/rooms/{roomNumber}/reservations")
    public List<Long> getReservationsByPaging(
        @PathVariable Long hotelId,
        @PathVariable String roomNumber,
        Pageable pageable) {

        System.out.println("Param param : " + pageable.getPageNumber());
        System.out.println("Size param : " + pageable.getPageSize());
        System.out.println("Offset param : " + pageable.getOffset());

        pageable.getSort()
                .stream()
                .forEach(order -> {
                    System.out.println("Sort param : " + order.getProperty() + ": " + order.getDirection());
                });

        return Collections.emptyList();
    }
}
