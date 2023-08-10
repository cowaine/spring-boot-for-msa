package com.cowaine.dingcook.domain.price;

import java.math.BigDecimal;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringBean01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBean01Application.class, args);

        PriceUnit defaultPriceUnit = context.getBean("priceUnit", PriceUnit.class);
        log.info("Price #1: {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));
    }

    @Bean(name = "priceUnit")
    public PriceUnit dollarPriceUnit() {
        return new PriceUnit(Locale.US);
    }
}
