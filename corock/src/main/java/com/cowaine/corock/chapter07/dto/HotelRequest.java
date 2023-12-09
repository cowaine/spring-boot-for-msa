package com.cowaine.corock.chapter07.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class HotelRequest {

    private Long hotelName;

    @Builder
    public HotelRequest(Long hotelName) {
        this.hotelName = hotelName;
    }

}
