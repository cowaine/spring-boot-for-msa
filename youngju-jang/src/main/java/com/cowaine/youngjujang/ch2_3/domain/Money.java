package com.cowaine.youngjujang.ch2_3.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.Currency;
import java.util.Objects;
// 불변클래스 설계방법

// 1. 상속방지, 메소드 오버라이드 방지용 `final class` 선언
@Getter // 4. setter 없이, getter 만 만들것
public final class Money implements Serializable {
     // 2. 멤버변수들을 final 선언
     private final Long value;
     private final Currency currency;
     
     // 3. 생성자 직접선언하여 기본생성자 없도록 할 것
     // 정적팩토리 메소드로 설계된 클래스는 반드시 private 으로 정의된 생성자를 선언할 것 (ex: Money valueOf(Long value, Currency currency))
     public Money(Long value, Currency currency) {
          if (value == null || value < 0) {
               throw new IllegalArgumentException("invalid value=" + value);
          }
          if(currency == null){
               throw new IllegalArgumentException("invalid currency");
          }
          this.value = value;
          this.currency = currency;
     }
     
     @Override
     public boolean equals(Object obj) {
          if (this == obj) {
               return true;
          }
          if (obj == null || getClass() != obj.getClass()) {
               return false;
          }
          Money money = Money.class.cast(obj);
          return Objects.equals(value, money.value) &&
               Objects.equals(currency, money.currency);
     }
}
