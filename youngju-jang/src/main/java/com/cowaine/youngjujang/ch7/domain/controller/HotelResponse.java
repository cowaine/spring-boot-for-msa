package com.cowaine.youngjujang.ch7.domain.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class HotelResponse {
     private Long hotelId;
     private String hotelName;
     private String address;
     private String phoneNumber;
}
