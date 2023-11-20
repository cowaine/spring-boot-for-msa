package com.cowaine.dingcook.chapter07.controller;

import com.cowaine.dingcook.chapter07.domain.HotelRoomEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HotelRoomResponse {

    private Long hotelRoomId;
    private String code;
    private Integer floor;
    private Integer bedCount;
    private Integer bathCount;

//    public static HotelRoomResponse from(HotelRoomEntity hotelRoomEntity) {
//        return new HotelRoomResponse(hotelRoomEntity.getId(),
//            hotelRoomEntity.getCode(),
//            hotelRoomEntity.getFloor(),
//            hotelRoomEntity.getBedCount(),
//            hotelRoomEntity.getBathCount());
//    }
}
