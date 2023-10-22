package com.cowaine.crupy.part7.service;

import com.cowaine.crupy.part7.config.TestConfig;
import com.cowaine.crupy.part7.controller.HotelRoomResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
//@Import(TestConfig.class)
@ContextConfiguration(classes = TestConfig.class)
@TestPropertySource(properties = {"spring.config.location = classpath:application-test.yaml"})
// properties대신에 yml로 설정하려면 이렇게 적어야 됨.
public class HotelRoomDisplayServiceTest01 {

    @Autowired
    private HotelRoomDisplayService hotelRoomDisplayService;

    @Test
    public void testTestConfiguration() {
        HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(1L);

        Assertions.assertNotNull(hotelRoomResponse);
        Assertions.assertEquals(1L, hotelRoomResponse.getHotelRoomId());
    }

}
