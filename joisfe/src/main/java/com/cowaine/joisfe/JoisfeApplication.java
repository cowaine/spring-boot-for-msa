package com.cowaine.joisfe;

import com.cowaine.joisfe.part3.PriceUnit;
import java.math.BigDecimal;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Slf4j
@SpringBootApplication
public class JoisfeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctxt = SpringApplication.run(JoisfeApplication.class, args);

        PriceUnit defaultPriceUnit = ctxt.getBean("priceUnit", PriceUnit.class);
        log.info("Price #1 : {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));

        PriceUnit wonPriceUnit = ctxt.getBean("wonPriceUnit", PriceUnit.class);
        log.info("Price #2 : {}", wonPriceUnit.format(BigDecimal.valueOf(1000)));

        ctxt.close();
    }

    @Bean(name = "priceUnit")
    public PriceUnit dolloarPriceUnit() {
        return new PriceUnit(Locale.US);
    }

    @Bean
    public PriceUnit wonPriceUnit() {
        return new PriceUnit(Locale.KOREA);
    }
}
