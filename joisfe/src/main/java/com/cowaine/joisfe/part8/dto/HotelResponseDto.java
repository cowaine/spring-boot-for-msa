package com.cowaine.joisfe.part8.dto;

import com.cowaine.joisfe.part8.domain.HotelEntity;
import com.cowaine.joisfe.part8.domain.HotelStatus;
import lombok.Getter;

@Getter
public class HotelResponseDto {

    public static final HotelResponseDto EMPTY = new HotelResponseDto();

    private Long hotelId;
    private HotelStatus hotelStatus;
    private String name;
    private String phoneNumber;
    private String address;

    private HotelResponseDto() {

    }

    public static HotelResponseDto of(HotelEntity hotelEntity) {

        HotelResponseDto hotelResponseDto = new HotelResponseDto();
        hotelResponseDto.hotelId = hotelEntity.getHotelId();
        hotelResponseDto.hotelStatus = hotelEntity.getStatus();
        hotelResponseDto.name = hotelEntity.getName();
        hotelResponseDto.address = hotelEntity.getAddress();
        hotelResponseDto.phoneNumber = hotelEntity.getPhoneNumber();

        return hotelResponseDto;
    }
}
