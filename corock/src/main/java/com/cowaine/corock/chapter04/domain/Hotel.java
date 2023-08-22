package com.cowaine.corock.chapter04.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Hotel {

    private final Long id;
    private final String name;
    private final String address;
    private final Integer roomCount;

    public static Hotel newInstance(Long id, String name, String address, int roomCount) {
        return new Hotel(id, name, address, roomCount);
    }

}
