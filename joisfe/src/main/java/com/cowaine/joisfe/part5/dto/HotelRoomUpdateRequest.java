package com.cowaine.joisfe.part5.dto;

import com.cowaine.joisfe.part5.domain.HotelRoomType;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HotelRoomUpdateRequest {

    @NotNull(message = "roomType can't be null")
    private HotelRoomType roomType;

    @NotNull(message = "originalPrice can't be null")
    @Min(value = 0, message = "originalPrice must be larger than 0")
    private BigDecimal originalPrice;
}
