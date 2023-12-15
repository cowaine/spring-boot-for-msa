package com.cowaine.ahngilwoong.chapter8.model;

import com.cowaine.ahngilwoong.chapter8.domain.HotelEntity;
import com.cowaine.ahngilwoong.chapter8.enums.HotelStatus;
import lombok.Getter;

@Getter
public class HotelResponse {

    public static final HotelResponse EMPTY = new HotelResponse();

    private Long hotelId;
    private HotelStatus hotelStatus;
    private String name;
    private String phoneNumber;
    private String address;

    private HotelResponse() {

    }

    public static HotelResponse of(HotelEntity hotelEntity) {

        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.hotelId = hotelEntity.getHotelId();
        hotelResponse.hotelStatus = hotelEntity.getStatus();
        hotelResponse.name = hotelEntity.getName();
        hotelResponse.address = hotelEntity.getAddress();
        hotelResponse.phoneNumber = hotelEntity.getPhoneNumber();

        return hotelResponse;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public HotelStatus getHotelStatus() {
        return hotelStatus;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
}
