package com.cowaine.corock.chapter06.controller.converter;

import com.cowaine.corock.chapter06.domain.HotelRoomNumber;
import org.springframework.core.convert.converter.Converter;

public class HotelRoomNumberConverter implements Converter<String, HotelRoomNumber> {

    @Override
    public HotelRoomNumber convert(String source) {
        return HotelRoomNumber.parse(source);
    }

}
