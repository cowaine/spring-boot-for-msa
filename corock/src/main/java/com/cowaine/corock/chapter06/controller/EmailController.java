package com.cowaine.corock.chapter06.controller;

import com.cowaine.corock.chapter06.domain.email.EmailAddress;
import com.cowaine.corock.chapter06.domain.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}/reservations/{reservationId}/send")
    public ResponseEntity<Void> sendEmailByReservation(@PathVariable final Long hotelId,
                                                       @PathVariable final String roomNumber,
                                                       @PathVariable final Long reservationId) {

        emailService.sendEmail(new EmailAddress("Byungboo Kim", "byungboor", "naver.com"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
