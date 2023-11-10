package com.cowaine.corock.chapter08.domain.converter;

import com.cowaine.corock.chapter08.domain.HotelRoomType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import java.util.Objects;

@Component
public class HotelRoomTypeConverter implements AttributeConverter<HotelRoomType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(HotelRoomType attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public HotelRoomType convertToEntityAttribute(Integer dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }
        return HotelRoomType.fromValue(dbData);
    }

}
