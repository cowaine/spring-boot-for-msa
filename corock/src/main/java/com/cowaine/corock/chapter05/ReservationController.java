package com.cowaine.corock.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
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

    @GetMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}/reservations/{reservationId}")
    public ResponseEntity<byte[]> getInvoice(@PathVariable final Long hotelId, @PathVariable final String roomNumber,
                                             @PathVariable final Long reservationId) {

        String filePath = "pdf/hotel_invoice.pdf";
        try (InputStream inputStream = new ClassPathResource(filePath).getInputStream()) {
            byte[] bytes = StreamUtils.copyToByteArray(inputStream);
            return new ResponseEntity<>(bytes, HttpStatus.OK);

        } catch (Throwable cause) {
            cause.printStackTrace();
            throw new FileDownloadException("file download error");
        }
    }

    @GetMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}/reservations/{reservationId}",
                produces = "application/pdf")
    public void downloadInvoice(@PathVariable final Long hotelId, @PathVariable final String roomNumber,
                                @PathVariable final Long reservationId, HttpServletResponse response) {

        String filePath = "pdf/hotel_invoice.pdf";
        try (InputStream is = new ClassPathResource(filePath).getInputStream();
             OutputStream os = response.getOutputStream()) {

            response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            response.setHeader("Content-Disposition", "filename=hotel_invoice.pdf");

            StreamUtils.copy(is, os);

        } catch (Throwable cause) {
            cause.printStackTrace();
            throw new FileDownloadException("file download error");
        }
    }

}
