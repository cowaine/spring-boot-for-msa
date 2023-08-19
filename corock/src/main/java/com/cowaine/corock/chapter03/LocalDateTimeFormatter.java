package com.cowaine.corock.chapter03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

    private final DateTimeFormatter formatter;

    public LocalDateTimeFormatter() {
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    }

    @Override
    public String of(LocalDateTime target) {
        return Optional.ofNullable(target)
                .map(formatter::format)
                .orElse(null);
    }

}
