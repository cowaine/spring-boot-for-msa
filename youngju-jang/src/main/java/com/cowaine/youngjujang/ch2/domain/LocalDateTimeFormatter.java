package com.cowaine.youngjujang.ch2.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
@Component
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
     private final DateTimeFormatter formatter =
          DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
     
     @Override
     public String of(LocalDateTime target) {
          return Optional.ofNullable(target)
               .map(formatter::format)
               .orElse(null);
     }
}
