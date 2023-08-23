package com.cowaine.joisfe;

import com.cowaine.joisfe.part3.DateFormatter;
import com.cowaine.joisfe.part3.Formatter;
import com.cowaine.joisfe.part3.LifeCycleComponent;
import com.cowaine.joisfe.part3.PriceUnit;
import com.cowaine.joisfe.part3.PrintableBeanPostProcessor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Slf4j
@SpringBootApplication
public class JoisfeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(JoisfeApplication.class, args);

        // @Bean 애너테이션에서 name 속성을 통해 이름 지정
        PriceUnit defaultPriceUnit = applicationContext.getBean("priceUnit", PriceUnit.class);
        log.info("Price #1 : {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));

        // @Bean에서 value 혹은 name 명시가 없다면 메서드 명으로 bean name 만들어짐
        PriceUnit wonPriceUnit = applicationContext.getBean("wonPriceUnit", PriceUnit.class);
        log.info("Price #2 : {}", wonPriceUnit.format(BigDecimal.valueOf(1000)));

        // NoUniqueBeanDefinitionException 을 해결하기 위해 @Primary 애너테이션 사용
        PriceUnit priceUnit = applicationContext.getBean(PriceUnit.class);
        log.info("Locale in PriceUnit : {}", priceUnit.getLocale().toString());

        // @Lazy 애너테이션을 통해 해당 스프링 빈을 생성하는 시점을 확인
        log.info("-------- Done to initialize spring beans");
        PriceUnit lazyPriceUnit = applicationContext.getBean("lazyPriceUnit", PriceUnit.class);
        // @Lazy가 없다면 lazyPriceUnit 빈을 등록한 메서드 내 log가 아래 로그보다 먼저 찍혔을 것이지만 @Lazy가 있으므로 반대
        log.info("Locale in LazyPriceUnit : {}", lazyPriceUnit.getLocale().toString());

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

    @Bean(initMethod = "init", destroyMethod = "clear")
    public LifeCycleComponent lifeCycleComponent() {
        return new LifeCycleComponent();
    }

    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new PrintableBeanPostProcessor();
    }

    @Bean
    @Primary
    public PriceUnit primaryPriceUnit() {
        return new PriceUnit(Locale.US);
    }

    @Bean
    public PriceUnit secondaryPriceUnit() {
        return new PriceUnit(Locale.KOREA);
    }

    @Bean
    @Lazy
    public PriceUnit lazyPriceUnit() {
        //
        log.info("initialize lazyPriceUnit");
        return new PriceUnit(Locale.US);
    }
}
