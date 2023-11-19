package com.cowaine.corock;

import com.cowaine.corock.chapter03.domain.PriceUnit;
import com.cowaine.corock.chapter03.di.DateFormatter;
import com.cowaine.corock.chapter03.di.Formatter;
import com.cowaine.corock.chapter03.lifecycle.LifeCycleComponent;
import com.cowaine.corock.chapter03.lifecycle.PrintableBeanPostProcessor;
import com.cowaine.corock.chapter07.dto.HotelRequest;
import com.cowaine.corock.chapter07.service.DisplayService;
import com.cowaine.corock.chapter09.adaptor.BillingAdaptor;
import com.cowaine.corock.chapter09.billing.BillingCodeResponse;
import com.cowaine.corock.chapter09.billing.CreateCodeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = { "com.cowaine.corock.chapter06" })
public class CorockApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CorockApplication.class, args);

        BillingAdaptor billingAdaptor = ctx.getBean(BillingAdaptor.class);

        List<BillingCodeResponse> responses = billingAdaptor.getBillingCodes("CODE:1231231");
        log.info("1. Result: {}", responses);

        CreateCodeResponse createCodeResponse = billingAdaptor.create(List.of(1231231L));
        log.info("2. Result: {}", createCodeResponse);

        CreateCodeResponse codeResponse = billingAdaptor.createBillingCode(List.of(9_000L, 8_000L, 7_000L));
        log.info("3. Result: {}", codeResponse);

        // CorockApplication.p99(ctx);
        // CorockApplication.p110(ctx);
        // CorockApplication.p121(ctx);
        // CorockApplication.p148(ctx);
        // CorockApplication.p158(ctx);
        // CorockApplication.p160(ctx);
        // CorockApplication.p162(ctx);

        // CorockApplication.testAop(ctx);
    }

    private static void p99(ConfigurableApplicationContext ctx) {
        Environment env = ctx.getBean(Environment.class);
        String port = env.getProperty("server.port");
        log.info("Customized Port: {}", port);

        String[] beanNames = ctx.getBeanDefinitionNames();
        IntStream.range(0, beanNames.length)
                .forEach(i -> log.info("Bean Name #{}: {}", i + 1, beanNames[i]));
    }

    private static void p110(ConfigurableApplicationContext ctx) {
        PriceUnit defaultPriceUnit = ctx.getBean("priceUnit", PriceUnit.class);
        log.info("Price #1: {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));

        PriceUnit wonPriceUnit = ctx.getBean("wonPriceUnit", PriceUnit.class);
        log.info("Price #2: {}", wonPriceUnit.format(BigDecimal.valueOf(1_000)));

        // Exception in thread "main" o.s.b.f.NoSuchBeanDefinitionException: No bean named 'testPriceUnit' available
        // PriceUnit testPriceUnit = ctx.getBean("testPriceUnit", PriceUnit.class);
    }

    /**
     * 스프링 빈을 정의한다.
     *
     * @return {@link PriceUnit}
     * @throws org.springframework.beans.factory.NoUniqueBeanDefinitionException No qualifying bean of type 'com.cowaine.corock.chapter03.domain.PriceUnit' available: expected single matching bean but found 2: priceUnit,wonPriceUnit
     */
    @Primary
    @Bean(name = "priceUnit")
    public PriceUnit dollarPriceUnit() {
        return new PriceUnit(Locale.US);
    }

    @Lazy
    @Bean
    public PriceUnit lazyPriceUnit() {
        log.info("initialize lazyPriceUnit");
        return new PriceUnit(Locale.KOREAN);
    }

    @Bean
    public PriceUnit wonPriceUnit() {
        return new PriceUnit(Locale.KOREA);
    }

    private static void p121(ConfigurableApplicationContext ctx) {
        Formatter<LocalDateTime> formatter = ctx.getBean("localDateTimeFormatter", Formatter.class);
        String date = formatter.of(LocalDateTime.of(2020, 12, 24, 23, 59, 59));

        log.info("Date: " + date);
    }

    private static void p148(ConfigurableApplicationContext ctx) throws InterruptedException {
        ThreadPoolTaskExecutor taskExecutor = ctx.getBean(ThreadPoolTaskExecutor.class);
        final String dateString = "2020-12-24T23:59:59.-08:00";

        for (int i = 0; i < 100; i++) {
            taskExecutor.submit(() -> {
                DateFormatter dateFormatter = ctx.getBean("singletonDateFormatter", DateFormatter.class);
                try {
                    log.info("Date: {}, hashCode: {}", dateFormatter.parse(dateString), dateFormatter.hashCode());
                } catch (ParseException e) {
                    log.error("error to parse", e);
                }
            });
        }

        TimeUnit.SECONDS.sleep(5);
    }

    @Scope(scopeName = "prototype")
    @Bean
    public DateFormatter singletonDateFormatter() {
        return new DateFormatter("yyyy-MM-dd'T'HH:mm:ss");
    }


    // @Bean(initMethod = "init", destroyMethod = "clear")

    public LifeCycleComponent lifeCycleComponent() {
        return new LifeCycleComponent();
    }
    // @Bean

    public BeanPostProcessor beanPostProcessor() {
        return new PrintableBeanPostProcessor();
    }
    private static void p158(ConfigurableApplicationContext ctx) {
        PriceUnit priceUnit = ctx.getBean(PriceUnit.class);
        log.info("Locale in PriceUnit: {}", priceUnit.getLocale().toString());
    }

    private static void p160(ConfigurableApplicationContext ctx) {
        Object obj = ctx.getBean("systemId");
        log.warn("Bean Info. type: {}, value: {}", obj.getClass(), obj);
    }

    private static void p162(ConfigurableApplicationContext ctx) {
        log.info("------- Done to initialize spring beans");
        PriceUnit priceUnit = ctx.getBean("lazyPriceUnit", PriceUnit.class);
        log.info("Locale in PriceUnit: {}", priceUnit.getLocale().toString());

        ctx.close();
    }

    /**
     * @see <a href="https://github.com/gilbutITbook/080264/blob/main/spring-boot-example/chapter07/src/main/java/com/springtour/example/chapter07/Chapter07Application.java">Chapter07Application.java</a>
     * @param ctx
     */
    private static void testAop(ConfigurableApplicationContext ctx) {
        DisplayService displayService = ctx.getBean(DisplayService.class);
        displayService.getHotelsByName(new HotelRequest("Ragged Point Inn"));
                // .forEach(hotelResponse -> log.info("response: {}", hotelResponse));
    }

}
