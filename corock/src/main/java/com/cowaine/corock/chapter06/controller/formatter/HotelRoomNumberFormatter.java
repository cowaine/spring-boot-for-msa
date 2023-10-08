package com.cowaine.corock.chapter06.controller.formatter;

import com.cowaine.corock.chapter06.domain.HotelRoomNumber;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
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
