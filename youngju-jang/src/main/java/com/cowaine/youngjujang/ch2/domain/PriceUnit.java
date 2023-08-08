package com.cowaine.youngjujang.ch2.domain;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Getter
public class PriceUnit {
     private final Locale locale;
     
     public PriceUnit(Locale locale) {
          if (Objects.isNull(locale)) {
               throw new IllegalArgumentException("locale arg is null");
          }
          this.locale = locale;
     }
     
     // 클래스속성인 locale을 사용하여 화폐포맷으로 변경
     public String format(BigDecimal price){
          NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
          
          // NumberFormat : 스레드안전하지 않아 format메서드 내부에서 매번 객체를 생성해야한다
          return currencyFormat.format(
               Optional.ofNullable(price).orElse(BigDecimal.ZERO)
          );
     }
     public void validate(){
          if(Objects.isNull(locale)){
               throw new IllegalStateException("locale is null");
          }
          log.info("locale is [{}]", locale);
     }
}
