package com.cowaine.youngjujang.ch5.domain.dto;

import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomType;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@ToString
public class HotelRoomUpdateRequest {
     // spring-boot-starter-validation 추가 >> bean 자동으로 검증가능 (@Valid 애너테이션 조합 필요)
     @NotNull (message = "roomType can't be null")
     private HotelRoomType roomType;
     
     @NotNull (message = "originalPrice can't be null")
     @Min (value = 0, message = "originalPrice must be larger than 0")
     private BigDecimal originalPrice;
}
