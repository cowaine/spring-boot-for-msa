package com.cowaine.ahngilwoong.chapter8.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelCreateRequest {

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    private String name;
    private String address;
    private String phoneNumber;
    private Integer roomCount;

}
