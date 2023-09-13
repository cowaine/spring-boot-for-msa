package com.cowaine.crupy.part6.domain.hotelroom.controller.converter;

import com.cowaine.crupy.part6.domain.hotelroom.HotelRoomNumber;
import org.springframework.core.convert.converter.Converter;

public class HotelRoomNumberConverter implements Converter<String, HotelRoomNumber> {

    @Override
    public HotelRoomNumber convert(String source) {
        return HotelRoomNumber.parse(source);
    }
}
