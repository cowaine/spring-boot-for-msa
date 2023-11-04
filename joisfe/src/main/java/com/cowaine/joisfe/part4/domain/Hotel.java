package com.cowaine.joisfe.part4.domain;

import java.util.Objects;
import lombok.Getter;

@Getter
public class Hotel {

    private Long hotelId;

    private String name;

    private String address;

    private Integer roomCount;

    public Hotel(Long hotelId, String name, String address, Integer roomCount) {

        if (Objects.isNull(hotelId) || Objects.isNull(name) || Objects.isNull(address)) {
            throw new IllegalArgumentException("invalid hotel constraint");
        }

        if (Objects.isNull(roomCount) || roomCount <= 0) {
            throw new IllegalArgumentException("invalid room count");
        }

        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
        this.roomCount = roomCount;
    }
}
