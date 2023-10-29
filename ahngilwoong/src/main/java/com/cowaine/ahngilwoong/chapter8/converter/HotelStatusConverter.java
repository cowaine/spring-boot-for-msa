package com.cowaine.ahngilwoong.chapter8.converter;

import com.cowaine.ahngilwoong.chapter8.enums.HotelStatus;
import java.util.Objects;
import javax.persistence.AttributeConverter;

public class HotelStatusConverter implements AttributeConverter<HotelStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(HotelStatus attribute) {
        if (Objects.isNull(attribute))
            return null;

        return attribute.getValue();
    }

    @Override
    public HotelStatus convertToEntityAttribute(Integer dbData) {

        if (Objects.isNull(dbData))
            return null;

        return HotelStatus.fromValue(dbData);
    }
}
