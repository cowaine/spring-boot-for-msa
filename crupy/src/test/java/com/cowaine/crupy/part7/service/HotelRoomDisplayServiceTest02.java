package com.cowaine.crupy.part7.service;

import com.cowaine.crupy.part7.controller.HotelRoomResponse;
import com.cowaine.crupy.part7.entity.HotelRoomEntity;
import com.cowaine.crupy.part7.repository.HotelRoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class HotelRoomDisplayServiceTest02 {

    @Autowired
    private HotelRoomDisplayService hotelRoomDisplayService;

    @MockBean
    private HotelRoomRepository hotelRoomRepository;

    @Test
    public void testMockBean() {

        given(this.hotelRoomRepository.findById(any()))
                .willReturn(new HotelRoomEntity(10L, "test", 1, 1, 1));

        HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(1L);

        Assertions.assertNotNull(hotelRoomResponse);
        Assertions.assertEquals(10L, hotelRoomResponse.getHotelRoomId());
    }
}
