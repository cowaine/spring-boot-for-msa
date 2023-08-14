package com.cowaine.youngjujang;

import com.cowaine.youngjujang.ch2.domain.Formatter;
import com.cowaine.youngjujang.ch2.domain.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;


@Slf4j
@SpringBootApplication
public class YoungjuJangApplication {
    public static void main(String[] args) {
        
        ConfigurableApplicationContext ctx = SpringApplication.run(YoungjuJangApplication.class, args);
        
        // 클래스타입도 같이 보냄 >> 클래스타입의 객체로 리턴해줌 (클래스타입으로의 casting이 필요없음)
        Formatter formatter = ctx.getBean("localDateTimeFormatter", Formatter.class);
        String date = formatter.of(LocalDateTime.of(2020, 12, 24, 23, 59, 59));
        
        log.info("Date : " + date);
        ctx.close();
    }
    
    @Bean (name="priceUnit")
    public PriceUnit dollarPriceUnit(){
        return new PriceUnit(Locale.US);
    }
    
    @Bean
    public PriceUnit wonPriceUnit(){
        return new PriceUnit(Locale.KOREA);
    }
}
