package com.cowaine.corock.chapter04.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Hotel {

    private Long id;
    private String name;
    private String address;
    private Integer roomCount;

}
