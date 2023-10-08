package com.cowaine.youngjujang.ch6.domain.controller.converter;

import com.cowaine.youngjujang.ch6.domain.HotelRoomNumber;
import org.springframework.core.convert.converter.Converter;

public class HotelRoomNumberConverter implements Converter<String, HotelRoomNumber> {
     @Override
     public HotelRoomNumber convert(String source) {
          return HotelRoomNumber.parse(source);
     }
}
