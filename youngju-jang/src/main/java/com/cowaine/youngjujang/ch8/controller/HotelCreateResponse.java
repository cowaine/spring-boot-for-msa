package com.cowaine.youngjujang.ch8.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HotelCreateResponse {
     private Long hotelId;
     
     public static HotelCreateResponse of(Long hotelId){
          HotelCreateResponse response = new HotelCreateResponse();
          response.hotelId = hotelId;
          return response;
     }
}
