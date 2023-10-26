package com.cowaine.youngjujang.ch8.scheme.domain;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public class HotelStatusConverter implements AttributeConverter<HotelStatus, Integer> {
     @Override
     public Integer convertToDatabaseColumn(HotelStatus attribute) { // HotelStatus 을 db컬럼값으로 변경
          if(Objects.isNull(attribute)){
               return null;
          }
          return attribute.getValue();
     }
     
     @Override
     public HotelStatus convertToEntityAttribute(Integer dbData) {
          if(Objects.isNull(dbData)){
               return null;
          }
          return HotelStatus.fromValue(dbData); // db값에서 HotelStatus 값으로 변경
     }
}
