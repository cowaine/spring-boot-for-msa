package com.cowaine.joisfe.part8.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelCreateRequestDto {

    private String name;
    private String address;
    private String phoneNumber;
    private Integer roomCount;

}