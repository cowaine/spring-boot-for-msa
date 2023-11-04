package com.cowaine.coalong.chapter08.domain.converter;

import com.cowaine.coalong.chapter08.domain.HotelStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

// 애플리케이션 전체에 글로벌 설정
@Converter(autoApply = true)
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