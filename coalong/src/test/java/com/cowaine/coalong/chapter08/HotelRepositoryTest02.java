package com.cowaine.coalong.chapter08;

import com.cowaine.coalong.chapter08.domain.HotelEntity;
import com.cowaine.coalong.chapter08.domain.HotelStatus;
import com.cowaine.coalong.chapter08.repository.HotelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
//@TestPropertySource(locations = "classpath:application-test.yaml")
class HotelRepositoryTest02 {

    private static HotelEntity testHotelEntity;

    @Autowired
    private HotelRepository hotelRepository;

    @BeforeEach
    public void init() {
        testHotelEntity = HotelEntity.of("Potel", "In Pohang 35", "010-7615-3886", 50);
    }

    @Test
    public void testFindOne() {
        // Given
        hotelRepository.save(testHotelEntity);

        // When
        HotelEntity hotelEntity = hotelRepository.findOne(testHotelEntity.getHotel_id(), HotelStatus.READY);

        // Then
        Assertions.assertEquals(testHotelEntity, hotelEntity);
    }

    @Test
    public void testFindReadyOne() {
        // Given
        hotelRepository.save(testHotelEntity);

        // When
        HotelEntity hotelEntity = hotelRepository.findReadyOne(testHotelEntity.getHotel_id());

        // Then
        Assertions.assertEquals(testHotelEntity, hotelEntity);
    }

}
