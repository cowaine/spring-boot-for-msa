package com.cowaine.joisfe.part7.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@ToString
@AllArgsConstructor
public class HotelRoomEntity {

    private Long id;
    private String code;
    private Integer floor;
    private Integer bedCount;
    private Integer bathCount;
}
