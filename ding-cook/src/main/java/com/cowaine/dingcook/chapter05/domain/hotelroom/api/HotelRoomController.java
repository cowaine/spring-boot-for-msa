package com.cowaine.dingcook.chapter05.domain.hotelroom.api;

import com.cowaine.dingcook.chapter05.domain.hotelroom.HotelRoomType;
import com.cowaine.dingcook.chapter05.domain.hotelroom.response.HotelRoomResponse;
import com.cowaine.dingcook.chapter05.global.utils.IdGenerator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelRoomController {


    @GetMapping("/hotels/{hotelId}/rooms/{roomNumber}")
    public HotelRoomResponse getHotelRoomByPeriod(
        @PathVariable Long hotelId,
        @PathVariable String roomNumber,
        @RequestHeader(value="x-from-date", required=false)
        @RequestParam(value = "fromDate", required = false)
        @DateTimeFormat(pattern = "yyyyMMdd") LocalDate fromDate,
        @RequestHeader(value="x-to-date", required=false)
        @RequestParam(value = "toDate", required = false)
        @DateTimeFormat(pattern = "yyyyMMdd") LocalDate toDate
    ) {

        Long hotelRoomId = IdGenerator.create();
        BigDecimal originalPrice = new BigDecimal("130.00");

        HotelRoomResponse response = HotelRoomResponse.of(hotelRoomId, roomNumber, HotelRoomType.DOUBLE, originalPrice);

        if (Objects.nonNull(fromDate) && Objects.nonNull(toDate)) {
            fromDate.datesUntil(toDate.plusDays(1))
                    .forEach(response::reservedAt);
        }

        return response;
    }
}
