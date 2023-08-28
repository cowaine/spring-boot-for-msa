package com.cowaine.youngjujang.ch5.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

@RestController
public class ReservationController {
     
     //localhost:8080/hotels/12/rooms/abc/reservations?page=1&size=50&sort=reservationId,desc&sort=reservationDate,desc
     @GetMapping("/hotels/{hotelId}/rooms/{roomNumber}/reservations")
     public List<Long> getReservationsByPaging(
          @PathVariable Long hotelId,
          @PathVariable String roomNumber,
          Pageable pageable){
          System.out.println("Page param : " + pageable.getPageNumber());
          System.out.println("Size param : " + pageable.getPageSize());
          pageable.getSort().stream()
               .forEach(order -> {
                    System.out.println("Sort param: " + order.getProperty() + " : " + order.getDirection());
               });
          return Collections.emptyList();
     }
}
