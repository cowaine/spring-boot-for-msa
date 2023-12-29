package com.cowaine.corock.chapter08.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HotelCreateRequest {

    private String name;
    private String address;
    private String phoneNumber;
    private Integer roomCount;

}
