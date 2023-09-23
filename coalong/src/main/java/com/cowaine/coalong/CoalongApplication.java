package com.cowaine.coalong;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;

@Slf4j
@SpringBootApplication
public class CoalongApplication {

    public static void main(String[] args) {
        // 1) 스프링 컨테이너 ApplicationContext 객체 생성
        ConfigurableApplicationContext ctx = SpringApplication.run(CoalongApplication.class, args);

        // CoalongApplication.p99(ctx); /* chap2 예제 */

        PriceUnit defaultPriceUnit = ctx.getBean("priceUnit", PriceUnit.class);
        log.info("Price #1: {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));

        PriceUnit wonPriceUnit = ctx.getBean("wonPriceUnit", PriceUnit.class);
        log.info("Price #2: {}", wonPriceUnit.format(BigDecimal.valueOf(1_000)));

        ctx.close();

    }

    private static void p99(ConfigurableApplicationContext ctx) {

        // 2) Environment 인터페이스를 통해 Property 설정에 접근 가능
        Environment env = ctx.getBean(Environment.class);
        String portValue = env.getProperty("server.port");
        log.info("Customized Port : {}", portValue);

        // 스프링 컨테이너가 관리하는 Bean 들을 확인
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(name -> log.info("Bean Name : {}", name));

    }

    @Bean(name = "priceUnit")
    public PriceUnit dollarPriceUnit() {
        return new PriceUnit(Locale.US);
    }

    @Bean
    public PriceUnit wonPriceUnit() {
        return new PriceUnit(Locale.KOREA);
    }


}
