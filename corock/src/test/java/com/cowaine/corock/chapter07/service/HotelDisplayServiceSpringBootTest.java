package com.cowaine.corock.chapter07.service;

import com.cowaine.corock.chapter07.config.TestConfig;
import com.cowaine.corock.chapter07.dto.HotelRequest;
import com.cowaine.corock.chapter07.dto.HotelResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@Import(TestConfig.class)
// @ContextConfiguration(classes = TestConfig.class)
@TestPropertySource(properties = { "spring.config.location=classpath:application-test-h2.yaml" })
class HotelDisplayServiceSpringBootTest {

    @Autowired
    HotelDisplayService hotelDisplayService;

    @Autowired
    ApplicationContext applicationContext;

    @DisplayName("testReturnOneHotelWhenRequestIsHotelName")
    @Test
    void testReturnOneHotelWhenRequestIsHotelName() {
        // Given
        HotelRequest hotelRequest = new HotelRequest("Line hotel");

        // When
        List<HotelResponse> hotelResponses = hotelDisplayService.getHotelsByName(hotelRequest);

        // Then
        Assertions.assertNotNull(hotelResponses);
        Assertions.assertEquals(1, hotelResponses.size());
    }

    @DisplayName("testApplicationContext")
    @Test
    void testApplicationContext() {
        DisplayService displayService = applicationContext.getBean(DisplayService.class);

        Assertions.assertNotNull(displayService);
        Assertions.assertTrue(displayService instanceof HotelDisplayService);
    }

}
