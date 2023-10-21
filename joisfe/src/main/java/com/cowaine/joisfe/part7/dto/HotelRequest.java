package com.cowaine.joisfe.part7.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@ToString
@NoArgsConstructor
public class HotelRequest {
    private String hotelName;

    public HotelRequest(String hotelName) {
        this.hotelName = hotelName;
    }
}
