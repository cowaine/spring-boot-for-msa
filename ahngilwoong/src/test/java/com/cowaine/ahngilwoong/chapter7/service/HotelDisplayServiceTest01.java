package com.cowaine.ahngilwoong.chapter7.service;

import com.cowaine.ahngilwoong.chapter7.config.TestConfig;
import com.cowaine.ahngilwoong.chapter7.model.HotelRequest;
import com.cowaine.ahngilwoong.chapter7.model.HotelResponse;
import com.cowaine.ahngilwoong.chapter7.service.spec.DisplayService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class HotelDisplayServiceTest01 {

//    @Autowired
//    private HotelDisplayService hotelDisplayService;
//
//    @Autowired
//    public HotelDisplayServiceTest01(HotelDisplayService hotelDisplayService) {
//        this.hotelDisplayService = hotelDisplayService;
//    }
//    @Test
//    public void testTestConfiguration() {
//        List<HotelResponse> hotels = hotelDisplayService.getHotelsByName();
//        Assertions.assertNotNull(hotels);
//    }

}
