package com.cowaine.dingcook.chapter07.service;

import static org.junit.jupiter.api.Assertions.*;

import com.cowaine.dingcook.chapter07.controller.HotelRequest;
import com.cowaine.dingcook.chapter07.controller.HotelResponse;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class HotelDisplayServiceTest {

    private final HotelDisplayService hotelDisplayService;
    private final ApplicationContext applicationContext;

    @Autowired
    public HotelDisplayServiceTest(HotelDisplayService hotelDisplayService, ApplicationContext applicationContext) {
        this.hotelDisplayService = hotelDisplayService;
        this.applicationContext = applicationContext;
    }

    @Test
    public void testReturnOneHotelWhenRequestIsHotelName() {

        // Given
        HotelRequest hotelRequest = new HotelRequest("아난티코브");

        // WHEN
        List<HotelResponse> hotelResponses = hotelDisplayService.getHotelsByName(hotelRequest);

        //Then
        Assertions.assertNotNull(hotelResponses);
        Assertions.assertEquals(1, hotelResponses.size());
    }

    @Test
    public void testApplicationContext() {
        DisplayService displayService = applicationContext.getBean(DisplayService.class);

        Assertions.assertNotNull(displayService);
        Assertions.assertTrue(displayService instanceof HotelDisplayService);
    }
}