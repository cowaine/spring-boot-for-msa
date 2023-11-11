package com.cowaine.dingcook.chapter08.domain.converter;

import com.cowaine.dingcook.chapter08.domain.HotelRoomType;
import java.util.Objects;
import javax.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

@Component
public class HotelRoomTypeConverter implements AttributeConverter<HotelRoomType, Integer> {


    @Override
    public Integer convertToDatabaseColumn(HotelRoomType attribute) {
        if (Objects.isNull(attribute))
            return null;

        return attribute.getValue();
    }

    @Override
    public HotelRoomType convertToEntityAttribute(Integer dbData) {
        if (Objects.isNull(dbData))
            return null;

        return HotelRoomType.fromValue(dbData);
    }
}
