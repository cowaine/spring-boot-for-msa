package com.cowaine.youngjujang.ch5.domain.dto;

import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomType;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class HotelRoomRequest {
     private String roomNumber;
     private HotelRoomType roomType;
     private BigDecimal originalPrice;
}
