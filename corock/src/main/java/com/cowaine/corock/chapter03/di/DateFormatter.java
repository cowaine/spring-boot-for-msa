package com.cowaine.corock.chapter03.di;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter implements Formatter<Date> {

    private SimpleDateFormat simpleDateFormat;

    public DateFormatter(String pattern) {
        this.simpleDateFormat = new SimpleDateFormat(pattern);
    }

    @Override
    public String of(Date target) {
        return simpleDateFormat.format(target);
    }

}
