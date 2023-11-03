package com.cowaine.crupy.part8.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelCreateRequest {

    private String name;
    private String address;
    private String phoneNumber;
    private Integer roomCount;

}
