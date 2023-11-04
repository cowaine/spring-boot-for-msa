package com.cowaine.youngjujang.ch5.domain.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class ToDollarStringSerializer extends JsonSerializer<BigDecimal> {
     @Override
     public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
          gen.writeString(value.setScale(2).toString()); // 소수점아래 두자리로 설정 후 문자열로 변경
     }
}
