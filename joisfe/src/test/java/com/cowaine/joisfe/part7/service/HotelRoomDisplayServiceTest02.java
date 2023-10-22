package com.cowaine.joisfe.part7.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.cowaine.joisfe.part7.domain.HotelRoomEntity;
import com.cowaine.joisfe.part7.dto.HotelRoomResponse;
import com.cowaine.joisfe.part7.repository.HotelRoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
