package com.cowaine.corock.chapter03.di;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter implements Formatter<Date> {

    private SimpleDateFormat simpleDateFormat;

    public DateFormatter(String pattern) {
        if (/* StringUtils.isEmpty(pattern) */ !StringUtils.hasLength(pattern)) {
            throw new IllegalArgumentException("Pattern is empty");
        }
        this.simpleDateFormat = new SimpleDateFormat(pattern);
    }

    @Override
    public String of(Date target) {
        return simpleDateFormat.format(target);
    }

    public Date parse(String dateString) throws ParseException {
        return simpleDateFormat.parse(dateString);
    }

}
