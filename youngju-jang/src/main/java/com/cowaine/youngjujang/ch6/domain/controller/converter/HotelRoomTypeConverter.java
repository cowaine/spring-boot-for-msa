package com.cowaine.youngjujang.ch6.domain.controller.converter;


import com.cowaine.youngjujang.ch6.domain.dto.HotelRoomType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component // webMvcConfigure addFormatter() override 안해도 컨버터 구현체 등록됨
public class HotelRoomTypeConverter implements Converter<String, HotelRoomType> {
     @Override
     public HotelRoomType convert(String source) {
          return HotelRoomType.fromParam(source);
     }
}
