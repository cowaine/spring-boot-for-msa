package com.cowaine.youngjujang.ch8.domain.domain;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum HotelStatus {
     OPEN(1), CLOSED(-1), READY(0);
     
     // <integer, HotelStatus> map
     private static Map<Integer, HotelStatus> valueMap = Arrays.stream(HotelStatus.values())
          .collect(Collectors.toMap(HotelStatus::getValue, Function.identity()));
     
     private Integer value;
     
     public static HotelStatus fromValue(Integer value) { // value 로  HotelStatus 찾기
          if (value == null)
               throw new IllegalArgumentException("value is null");
          
          return valueMap.get(value);
     }
     
     public Integer getValue() { // HotelStatus 의 value값
          return value;
     }
     
}
