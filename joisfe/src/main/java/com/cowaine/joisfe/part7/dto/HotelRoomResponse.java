package com.cowaine.joisfe.part7.dto;

import com.cowaine.joisfe.part7.domain.HotelRoomEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public class HotelRoomResponse {

    private Long hotelRoomId;
    private String code;
    private Integer floor;
    private Integer bedCount;
    private Integer bathCount;

    public static HotelRoomResponse from(HotelRoomEntity hotelRoomEntity) {
        return new HotelRoomResponse(hotelRoomEntity.getId(),
            hotelRoomEntity.getCode(),
            hotelRoomEntity.getFloor(),
            hotelRoomEntity.getBedCount(),
            hotelRoomEntity.getBathCount());
    }
}
