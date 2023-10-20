package com.cowaine.dingcook.chapter07;

import com.cowaine.dingcook.chapter07.controller.HotelRequest;
import com.cowaine.dingcook.chapter07.service.DisplayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class Chapter07Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext contex = SpringApplication.run(Chapter07Application.class, args);

        DisplayService displayService = contex.getBean(DisplayService.class);
        displayService.getHotelsByName(new HotelRequest("Ragged Point Inn"))
                      .stream()
                      .forEach(hotelResponse -> log.info("response:{}", hotelResponse));
    }
}
