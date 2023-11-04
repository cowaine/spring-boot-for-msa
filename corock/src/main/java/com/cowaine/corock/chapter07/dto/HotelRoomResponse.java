package com.cowaine.corock.chapter07.dto;

import com.cowaine.corock.chapter07.domain.HotelRoomEntity;
import lombok.Getter;

@Getter
public class HotelRoomResponse {

    private final Long hotelRoomId;
    private final String code;
    private final Integer floor;
    private final Integer bedCount;
    private final Integer bathCount;

    public HotelRoomResponse(Long hotelRoomId, String code, Integer floor, Integer bedCount, Integer bathCount) {
        this.hotelRoomId = hotelRoomId;
        this.code = code;
        this.floor = floor;
        this.bedCount = bedCount;
        this.bathCount = bathCount;
    }

    public static HotelRoomResponse from(HotelRoomEntity hotelRoom) {
        return new HotelRoomResponse(hotelRoom.getId(), hotelRoom.getCode(), hotelRoom.getFloor(),
                hotelRoom.getBedCount(), hotelRoom.getBathCount());
    }

}
