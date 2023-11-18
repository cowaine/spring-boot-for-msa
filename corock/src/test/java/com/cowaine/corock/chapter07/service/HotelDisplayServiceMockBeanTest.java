package com.cowaine.corock.chapter07.service;

import com.cowaine.corock.chapter07.domain.HotelRoomEntity;
import com.cowaine.corock.chapter07.dto.HotelRoomResponse;
import com.cowaine.corock.chapter07.repository.HotelRoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class HotelDisplayServiceMockBeanTest {

    // @Autowired
    // HotelRoomDisplayService hotelRoomDisplayService;

    @MockBean
    HotelRoomRepository hotelRoomRepository;

    @DisplayName("testMockBean")
    @Test
    void testMockBean() {
        given(hotelRoomRepository.findById(any())).willReturn(new HotelRoomEntity(10L, "test", 1, 1, 1));

        // HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(1L);

        // Assertions.assertNotNull(hotelRoomResponse);
        // Assertions.assertEquals(10L, hotelRoomResponse.getHotelRoomId());
    }

}
