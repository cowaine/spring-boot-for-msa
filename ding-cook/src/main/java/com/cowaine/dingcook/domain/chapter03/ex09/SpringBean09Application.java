package com.cowaine.dingcook.domain.chapter03.ex09;

import com.cowaine.dingcook.domain.chapter03.ex01.PriceUnit;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@Slf4j
@SpringBootApplication
public class SpringBean09Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBean09Application.class);
        log.info("----- Done to initialize Spring Beans -----");

        PriceUnit priceUnit = applicationContext.getBean("lazyPriceUnit", PriceUnit.class);
        log.info("Locale in PriceUnit : {}", priceUnit.getLocale().toString());

        applicationContext.close();
    }

    @Bean
    @Lazy
    public PriceUnit lazyPriceUnit() {
        log.info("initialize lazyPriceUnit");
        return new PriceUnit(Locale.US);
    }
}
