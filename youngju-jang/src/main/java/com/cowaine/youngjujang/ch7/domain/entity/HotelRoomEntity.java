package com.cowaine.youngjujang.ch7.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

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