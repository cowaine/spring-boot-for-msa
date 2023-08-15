package com.cowaine.youngjujang.ch2.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.util.StringUtils.hasLength;

public class DateFormatter implements Formatter<Date> {
     
     // 스레드 안전하지 않은 클래스
     private SimpleDateFormat sdf;
     
     public DateFormatter(String pattern) {
          if(!hasLength(pattern)) {
               throw new IllegalArgumentException("Pattern is empty");
          }
          this.sdf = new SimpleDateFormat(pattern);
     }
     
     @Override
     public String of(Date target) {
          return sdf.format(target);
     }
     
     // sdf.parse메서드 : 스레드에 안전하지 않음
     public Date parse(String dateString) throws ParseException{
          return sdf.parse(dateString);
     }
}
