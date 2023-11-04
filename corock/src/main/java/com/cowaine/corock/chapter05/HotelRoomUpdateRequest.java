package com.cowaine.corock.chapter05;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@ToString
public class HotelRoomUpdateRequest {

    @NotNull(message = "roomType can't be null")
    private HotelRoomType hotelRoomType;

    @NotNull(message = "originalPrice can't be null")
    @Min(value = 0, message = "originalPrice must be larger than 0")
    private BigDecimal originalPrice;

}
