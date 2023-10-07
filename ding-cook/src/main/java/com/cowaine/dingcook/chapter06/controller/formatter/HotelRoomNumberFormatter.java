package com.cowaine.dingcook.chapter06.controller.formatter;

import com.cowaine.dingcook.chapter06.domain.HotelRoomNumber;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 * 해당 Formatter와 Converter가 다른 점은 Formatter는 다국어 처리가 가능하다.
 */
public class HotelRoomNumberFormatter implements Formatter<HotelRoomNumber> {

    @Override
    public HotelRoomNumber parse(String text, Locale locale) throws ParseException {
        return HotelRoomNumber.parse(text);
    }

    @Override
    public String print(HotelRoomNumber hotelRoomNumber, Locale locale) {
        return hotelRoomNumber.toString();
    }
}
