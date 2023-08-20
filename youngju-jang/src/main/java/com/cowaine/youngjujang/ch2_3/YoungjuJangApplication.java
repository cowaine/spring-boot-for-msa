package com.cowaine.youngjujang.ch2_3;

import com.cowaine.youngjujang.ch2_3.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;

import java.util.Locale;


@Slf4j
@SpringBootApplication
public class YoungjuJangApplication {
    public static void main(String[] args) throws InterruptedException {
        
        ConfigurableApplicationContext ctx = SpringApplication.run(YoungjuJangApplication.class, args);
        log.info("------------Done to initialize spring beans");
        PriceUnit priceUnit = ctx.getBean("lazyPriceUnit", PriceUnit.class);
        log.info("Locale in PriceUnit : {} ", priceUnit.getLocale().toString());
        
//        Object obj = ctx.getBean("systemId");
//        log.info("Bean Info. type:{}, value : {}", obj.getClass(), obj);
        ctx.close();
    }
    @Bean
    @Lazy
    public PriceUnit  lazyPriceUnit(){
        log.info("initialize lazyPriceUnit");
        return new PriceUnit(Locale.US);
    }
    // Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true
    @Bean
    @Primary
    public PriceUnit primaryPriceUnit(){
        return new PriceUnit(Locale.US);
    }
    @Bean
    public PriceUnit secondaryPriceUnit(){
        return new PriceUnit(Locale.KOREA);
    }
    
    @Configuration
    class SystemConfig1{
        @Bean
        public Long systemId(){
            return 1111L;
        }
    }
//    @Configuration
//    class SystemConfig2{
//        @Bean
//        public String systemId(){
//            return new String("OrderSystem");
//        }
//    }
    @Bean(initMethod = "init", destroyMethod = "clear")
    public LifeCycleComponent lifecycleComponent(){
        return new LifeCycleComponent();
    }
    
    @Bean(initMethod = "init", destroyMethod = "clear")
    public LifeCycleComponentVer2 lifeCycleComponentVer2(){
        return new LifeCycleComponentVer2();
    }
    
    @Bean
    public BeanPostProcessor beanPostProcessor(){
        return new PrintableBeanPostProcessor();
    }
}
