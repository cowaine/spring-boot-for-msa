package com.cowaine.youngjujang.ch6.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum HotelRoomType {
     DOUBLE("double"),
     SINGLE("single"),
     TRIPLE("triple"),
     QUAD("quad");
     
     private final String param; // 마셜링 후 사용되는 JSON 객체 값
     
     private static final Map<String, HotelRoomType> paramMap =
          Arrays.stream(HotelRoomType.values())
               .collect(Collectors.toMap(
                    HotelRoomType::getParam,
                    Function.identity()
               ));
     
     @JsonCreator // 언마셜링 과정에서 값벼놘에 사용되는 메서드 지정
     public static HotelRoomType fromParam(String param){
          return Optional.ofNullable(param)
               .map(paramMap::get)
               .orElseThrow(() -> new IllegalArgumentException("param is not valid"));
     }
     
     @JsonValue // 마셜링 과정에서 값변환에 사용되는 메서드 지정
     public String getParam(){
          return this.param;
     }
}
