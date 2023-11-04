package com.cowaine.joisfe.part5.dto;

import com.cowaine.joisfe.part5.domain.HotelRoomType;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HotelRoomRequest {

    private String roomNumber;
    private HotelRoomType roomType;
    private BigDecimal originalPrice;
}
