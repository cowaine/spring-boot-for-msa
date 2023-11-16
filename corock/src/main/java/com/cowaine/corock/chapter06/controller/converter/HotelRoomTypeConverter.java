package com.cowaine.corock.chapter06.controller.converter;

import com.cowaine.corock.chapter05.HotelRoomType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

// @Component
public class HotelRoomTypeConverter implements Converter<String, HotelRoomType> {

    @Override
    public HotelRoomType convert(String source) {
        return HotelRoomType.fromParam(source);
    }

}
