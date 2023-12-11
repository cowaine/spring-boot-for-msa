package com.cowaine.corock.chapter08.service;

import com.cowaine.corock.chapter08.controller.HotelCreateRequest;
import com.cowaine.corock.chapter08.controller.HotelCreateResponse;
import com.cowaine.corock.chapter08.domain.HotelEntity;
import com.cowaine.corock.chapter08.repository.HotelRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
// @ExtendWith(SpringExtension.class)
// @ContextConfiguration(classes = { HotelService.class, SimpleJpaRepository.class })
@TestPropertySource(properties = { "spring.config.location=classpath:application-test-h2.yaml" })
class HotelServiceTest {

    @Qualifier("HotelService08")
    @Autowired
    HotelService hotelService;

    @Autowired
    HotelRepository hotelRepository;

    @DisplayName("testCreateHotel")
    @Test
    void testCreateHotel() {
        // Given
        HotelCreateRequest request = new HotelCreateRequest();
        ReflectionTestUtils.setField(request, "name", "test");
        ReflectionTestUtils.setField(request, "address", "test address");
        ReflectionTestUtils.setField(request, "phoneNumber", "213-820-3642");
        ReflectionTestUtils.setField(request, "roomCount", 10);

        // When
        HotelCreateResponse response = hotelService.createHotel(request);
        // HotelEntity hotelEntity = hotelRepository.findById(response.getHotelId()).orElse(null);

        // Then
        assertNotNull(response);
        // assertEquals(request.getName(), hotelEntity.getName());
        // assertEquals(request.getAddress(), hotelEntity.getAddress());
        // assertEquals(request.getPhoneNumber(), hotelEntity.getPhoneNumber());
        // assertEquals(request.getRoomCount(), hotelEntity.getRoomCount());
    }

}
