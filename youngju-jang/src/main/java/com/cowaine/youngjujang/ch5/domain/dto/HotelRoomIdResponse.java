package com.cowaine.youngjujang.ch5.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class HotelRoomIdResponse {
     @JsonProperty ("id") // hotelRoomId 대신 id가 속성명이 됨
     @JsonSerialize (using = ToStringSerializer.class) // Long > String 으로 마셜링
     private final Long hotelRoomId;
     
     private HotelRoomIdResponse(Long hotelRoomId){
          if (Objects.isNull(hotelRoomId)) {
               throw new IllegalArgumentException("hotelRoomId is null");
          }
          this.hotelRoomId = hotelRoomId;
     }
     public static HotelRoomIdResponse from(Long hotelRoomId){
          return new HotelRoomIdResponse(hotelRoomId);
     }
}
