package com.cowaine.corock.chapter05;

import com.cowaine.corock.chapter05.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Slf4j
@RestController
public class HotelRoomController {

    private static final String HEADER_CREATED_AT = "X-CREATED-AT";

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

    @PostMapping(path = "/hotels/{hotelId}/rooms")
    public ResponseEntity<HotelRoomIdResponse> createHotelRoom(@PathVariable Long hotelId,
                                                               @RequestBody HotelRoomRequest hotelRoomRequest) {
        log.info(hotelRoomRequest.toString());

        MultiValueMapAdapter<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HEADER_CREATED_AT, dateFormatter.format(ZonedDateTime.now()));
        HotelRoomIdResponse body = HotelRoomIdResponse.from(1_002_003_004L);

        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }

    @GetMapping(path = "/hotels")
    public void getHotels() {
        log.info("getHotels()");
    }

    @GetMapping(path = "/hotels", params = "isOpen")
    public void getHotelsByOpen() {
        log.info("getHotelsByOpen()");
    }

    @GetMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}")
    public HotelRoomResponse getHotelRoomByPeriod(@PathVariable Long hotelId, @PathVariable String roomNumber,
            @RequestParam(value = "from", required = false) @DateTimeFormat(pattern = "yyyyMMdd") LocalDate fromDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(pattern = "yyyyMMdd") LocalDate toDate) {

        Long hotelRoomId = IdGenerator.create();
        BigDecimal originalPrice = new BigDecimal("130.00");

        HotelRoomResponse response = HotelRoomResponse.of(hotelRoomId, roomNumber, HotelRoomType.DOUBLE, originalPrice);

        if (Objects.nonNull(fromDate) && Objects.nonNull(toDate)) {
            fromDate.datesUntil(toDate.plusDays(1)).forEach(date -> response.reservedAt(date));
        }

        return response;
    }

    @DeleteMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}")
    public DeleteResultResponse deleteHotelRoom(@PathVariable Long hotelId, @PathVariable String roomNumber) {
        log.info("Delete Request. hotelId: {}, roomNumber: {}", hotelId, roomNumber);
        return new DeleteResultResponse(Boolean.TRUE, "success");
    }

}
