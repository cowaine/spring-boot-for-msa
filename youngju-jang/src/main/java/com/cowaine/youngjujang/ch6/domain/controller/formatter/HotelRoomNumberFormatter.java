package com.cowaine.youngjujang.ch6.domain.controller.formatter;

import com.cowaine.youngjujang.ch6.domain.HotelRoomNumber;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class HotelRoomNumberFormatter implements Formatter<HotelRoomNumber> {
     
     // converter와 비슷
     // 차이점 : 다국어 기능 처리 여부
     @Override
     public HotelRoomNumber parse(String text, Locale locale) throws ParseException {
          return HotelRoomNumber.parse(text);
     }
     
     @Override
     public String print(HotelRoomNumber hotelRoomNumber, Locale locale) {
          return hotelRoomNumber.toString();
     }
}
