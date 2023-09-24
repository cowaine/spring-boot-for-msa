package com.cowaine.coalong.chapter03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class OrderProduct {

    private final BigDecimal orderAmount;
    private final String buyerName;
    private final LocalDateTime orderAt;

}
