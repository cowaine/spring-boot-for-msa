package com.cowaine.crupy.part6.domain.hotelroom.controller.converter;

import com.cowaine.crupy.part5.dto.HotelRoomType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HotelRoomTypeConverter implements Converter<String, HotelRoomType> {

    @Override
    public HotelRoomType convert(String source) {
        return HotelRoomType.fromParam(source);
    }
}