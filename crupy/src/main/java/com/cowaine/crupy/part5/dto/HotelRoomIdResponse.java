package com.cowaine.crupy.part5.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;

import java.util.Objects;

@Getter
public class HotelRoomIdResponse {

    @JsonProperty("id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long hotelRoomId;

    public HotelRoomIdResponse(Long hotelRoomId) {
        if(Objects.isNull(hotelRoomId))
            throw new IllegalArgumentException("hotelRoomId is null");

        this.hotelRoomId = hotelRoomId;
    }

    public static HotelRoomIdResponse from(Long hotelRoomId){
        return new HotelRoomIdResponse(hotelRoomId);
    }
}
