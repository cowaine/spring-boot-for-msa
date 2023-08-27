package com.cowaine.dingcook.domain.chapter04.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Hotel {

    private final Long id;
    private final String name;
    private final String location;
    private final Integer price;
}
