package com.cowaine.dingcook.chapter05.domain.hotelroom.api;

import com.cowaine.dingcook.chapter05.domain.hotelroom.HotelRoomType;
import com.cowaine.dingcook.chapter05.domain.hotelroom.request.HotelRoomRequest;
import com.cowaine.dingcook.chapter05.domain.hotelroom.response.DeleteResultResponse;
import com.cowaine.dingcook.chapter05.domain.hotelroom.response.HotelRoomIdResponse;
import com.cowaine.dingcook.chapter05.domain.hotelroom.response.HotelRoomResponse;
import com.cowaine.dingcook.chapter05.global.utils.IdGenerator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * #### REST-API 요청
     * DELETE /hotels/{hotelId}/rooms/{roomNumber}
     * - hotelId : (필수) Long 타입이며, 호텔의 고유 아이디 값
     * - roomNumber : (필수) String 타입이며, 호텔 리소스에 포함된 객실 중에서 고유 한 아이디 값
     * #### REST-API 응답 {
     *     "isSuccess" : true,
     *     "message" : "success"
     * }
     */
    @DeleteMapping("/hotels/{hotelId}/rooms/{roomNumber}")
    public DeleteResultResponse deleteHotelRoom(
        @PathVariable Long hotelId,
        @PathVariable String roomNumber) {

        System.out.println("Delete Request. hotelId=" + hotelId + ", roomNumber" + roomNumber);

        return new DeleteResultResponse(Boolean.TRUE, "success");
    }

    /**
     * ### REST-API 요청
     * POST /hotels/{hotelId}/rooms
     * {
         * "roomNumber" : "West-Wing-3928", "roomType" : "double", "originalPrice" : "150.00"
     * }
     *
     * ### ### REST-API 응답
     * - [HEADER] X-CREATED-AT : yyyy-MM-dd'T'HH:mm:ssXXX
     *
     * {
     *     "id": "1201928193"
     * }
     */

    private static final String HEADER_CREATED_AT = "X-CREATED-AT";
    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
    @PostMapping("/hotels/{hotelId}/rooms")
    public ResponseEntity<HotelRoomIdResponse> createHotelRoom(
        @PathVariable Long hotelId,
        @RequestBody HotelRoomRequest hotelRoomRequest) {

        System.out.println(hotelRoomRequest.toString());

        LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HEADER_CREATED_AT, DATE_FORMATTER.format(ZonedDateTime.now()));

        HotelRoomIdResponse body = HotelRoomIdResponse.from(1_002_003_004L);

        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }
}
