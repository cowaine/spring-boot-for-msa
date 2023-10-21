package com.cowaine.corock.chapter07.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class HotelRoomEntity {

    private final Long id;
    private final String code;
    private final Integer floor;
    private final Integer bedCount;
    private final Integer bathCount;

}
