package com.cowaine.joisfe.part3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.util.StringUtils;

public class DateFormatter implements Formatter<Date> {

    private SimpleDateFormat sdf;

    public DateFormatter(String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            throw new IllegalArgumentException("Pattern is empty");
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
