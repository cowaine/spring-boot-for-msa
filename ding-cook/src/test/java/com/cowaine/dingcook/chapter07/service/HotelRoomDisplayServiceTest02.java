package com.cowaine.dingcook.chapter07.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;

import com.cowaine.dingcook.chapter07.controller.HotelRoomResponse;
import com.cowaine.dingcook.chapter07.domain.HotelRoomEntity;
import com.cowaine.dingcook.chapter07.repository.HotelRoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
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

    @Test
    public void testMockBean2() {
        given(this.hotelRoomRepository.findById(isA(Long.class)))
            .willReturn(new HotelRoomEntity(10L, "test", 1, 1, 1));

        HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(1L);

        Assertions.assertNotNull(hotelRoomResponse);
        Assertions.assertEquals(10L, hotelRoomResponse.getHotelRoomId());
    }

    @Test
    public void testUseAnswerMockBean() {
        given(this.hotelRoomRepository.findById(any()))
            .willAnswer((Answer<HotelRoomEntity>) invocation -> {
                Long id = invocation.getArgument(0);

                if (id != null && id > 10) {
                    return new HotelRoomEntity(id, "CODE", 10, 2, 2);
                }

                return new HotelRoomEntity(10L, "test", 1, 1, 1);
            });

        HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(11L);

        Assertions.assertNotNull(hotelRoomResponse);
        Assertions.assertEquals(11L, hotelRoomResponse.getHotelRoomId());
    }
}
