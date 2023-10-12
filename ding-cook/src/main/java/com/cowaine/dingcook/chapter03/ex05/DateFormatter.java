package com.cowaine.dingcook.chapter03.ex05;

import com.cowaine.dingcook.chapter03.ex02.Formatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

//@Component
public class DateFormatter implements Formatter<Date> {

    private final SimpleDateFormat sdf;

    public DateFormatter(String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            throw new IllegalStateException("Pattern is empty");
        }

        this.sdf = new SimpleDateFormat(pattern);
    }

    @Override
    public String of(Date target) {
        return sdf.format(target);
    }

    public Date parse(String dateString) throws ParseException {
        return sdf.parse(dateString);
    }
}
