package com.cowaine.joisfe.part7.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author : 조재철
 * @since 1.0
 */
@ToString
@Getter
@AllArgsConstructor
public class HotelResponse {

    private Long hotelId;
    private String hotelName;
    private String address;
    private String phoneNumber;
}
