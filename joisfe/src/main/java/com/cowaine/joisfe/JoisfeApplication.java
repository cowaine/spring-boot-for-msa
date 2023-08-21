package com.cowaine.joisfe;

import com.cowaine.joisfe.part3.DateFormatter;
import com.cowaine.joisfe.part3.Formatter;
import com.cowaine.joisfe.part3.PriceUnit;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Slf4j
@SpringBootApplication
public class JoisfeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(JoisfeApplication.class, args);

        PriceUnit defaultPriceUnit = applicationContext.getBean("priceUnit", PriceUnit.class);
        log.info("Price #1 : {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));

        PriceUnit wonPriceUnit = applicationContext.getBean("wonPriceUnit", PriceUnit.class);
        log.info("Price #2 : {}", wonPriceUnit.format(BigDecimal.valueOf(1000)));

        Formatter<LocalDateTime> formatter = applicationContext.getBean("localDateTimeFormatter", Formatter.class);
        String date = formatter.of(LocalDateTime.of(2020, 12, 24, 23, 59, 59));
        log.info("Date : " + date);

        ThreadPoolTaskExecutor taskExecutor = applicationContext.getBean(ThreadPoolTaskExecutor.class);

        final String dateString = "2020-12-24T23:59:59.-08:00";

        for (int i = 0; i < 100; ++i) {
            taskExecutor.submit(() ->{
                try {
                    // 멀티스레드에서 싱글톤 빈을 사용하면서 에러 발생 (Scope가 singleton인 경우)
                    // 싱글톤이기 때문에 해시코드는 같은 값
                    // prototype으로 수정하면 문제없이 실행 -> 당연히 해시코드도 다 다른 값
                    DateFormatter formatter2 = applicationContext.getBean("singletonDateFormatter", DateFormatter.class);
                    log.info("Date : {}, hashCode : {}", formatter2.parse(dateString), formatter2.hashCode());
                } catch (Exception e) {
                    log.error("error to parse", e);
                }
            });
        }

        applicationContext.close();
    }

    @Bean(name = "priceUnit")
    public PriceUnit dolloarPriceUnit() {
        return new PriceUnit(Locale.US);
    }

    @Bean
    public PriceUnit wonPriceUnit() {
        return new PriceUnit(Locale.KOREA);
    }

    @Bean
    @Scope("prototype")
    public DateFormatter singletonDateFormatter() {
        return new DateFormatter("yyyy-MM-dd'T'HH:mm:ss");
    }
}
