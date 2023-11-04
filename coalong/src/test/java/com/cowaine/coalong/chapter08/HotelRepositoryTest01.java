package com.cowaine.coalong.chapter08;

import com.cowaine.coalong.chapter08.domain.HotelEntity;
import com.cowaine.coalong.chapter08.domain.HotelStatus;
import com.cowaine.coalong.chapter08.repository.HotelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;


@DataJpaTest
/* 다중속성문서를 사용할 때는 Active Profiles 으로 Profiles 설정 필요
 #https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config */
@ActiveProfiles("test2")
@TestPropertySource(locations = "classpath:application-test2.yaml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // DataJPATest 에 포함되어있는 설정, Default 값은 ANY
class HotelRepositoryTest01 {

    private static HotelEntity testHotelEntity;

    @Autowired
    private HotelRepository hotelRepository;

    @BeforeEach
    public void init() {
        testHotelEntity = HotelEntity.of("Potel", "In Pohang 35", "010-7615-3886", 50);
    }

    @Test
    public void testFindByStatus() {
        // Given
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
