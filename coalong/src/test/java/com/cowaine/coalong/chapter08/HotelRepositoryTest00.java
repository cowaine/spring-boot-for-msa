package com.cowaine.coalong.chapter08;


import com.cowaine.coalong.chapter08.domain.HotelEntity;
import com.cowaine.coalong.chapter08.domain.HotelStatus;
import com.cowaine.coalong.chapter08.repository.HotelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional  /* 테스트가 끝난 후에 롤백한다. */
@TestPropertySource(locations = "classpath:application-test.yaml")
class HotelRepositoryTest00 {

    private static HotelEntity testHotelEntity;

    @Autowired
    private HotelRepository hotelRepository;

    @BeforeEach
    public void init() {
        testHotelEntity = HotelEntity.of("Potel", "In Pohang 35", "010-7615-3886", 50);
    }

    @Test
    public void testFindByStatus() {
        //Given
        hotelRepository.save(testHotelEntity);

        // When
        HotelEntity hotelEntity = hotelRepository.findByStatus(HotelStatus.READY)
                .stream()
                .filter(entity -> entity.getHotel_id().equals(testHotelEntity.getHotel_id()))
                .findFirst()
                .get();

        // Then
        Assertions.assertNotNull(hotelEntity);
        Assertions.assertEquals(testHotelEntity.getAddress(), hotelEntity.getAddress());
        Assertions.assertEquals(testHotelEntity.getName(), hotelEntity.getName());
        Assertions.assertEquals(testHotelEntity.getPhoneNumber(), hotelEntity.getPhoneNumber());

    }

}
