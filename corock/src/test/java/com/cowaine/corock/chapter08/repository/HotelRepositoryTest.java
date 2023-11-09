package com.cowaine.corock.chapter08.repository;

import com.cowaine.corock.chapter08.domain.HotelEntity;
import com.cowaine.corock.chapter08.domain.HotelStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

/**
 * @see <a href="https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#features.external-config.files.multi-document">Working With Multi-Document Files</a>
 */
// @SpringBootTest
@DataJpaTest
@TestPropertySource(properties = { "spring.config.location=classpath:application-test-h2.yaml" })
// @ActiveProfiles(profiles = "test-h2")
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class HotelRepositoryTest {

    private static HotelEntity testHotelEntity;

    @Autowired
    private HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        testHotelEntity = HotelEntity.of("The LINE LA", "3515 Wilshire Blvd, Los Angeles, CA 90010", "+12133817411");
    }

    @DisplayName("testFindByStatus")
    @Test
    void testFindByStatus() {
        // Given
        hotelRepository.save(testHotelEntity);

        // When
        Optional<HotelEntity> maybeHotelEntity = hotelRepository.findByStatus(HotelStatus.READY)
                .stream()
                .filter(h -> h.getHotelId().equals(testHotelEntity.getHotelId()))
                .findFirst();

        HotelEntity hotelEntity = null;
        if (maybeHotelEntity.isPresent()) {
            hotelEntity = maybeHotelEntity.get();
        }

        // Then
        Assertions.assertNotNull(hotelEntity);
        Assertions.assertEquals(testHotelEntity.getAddress(), hotelEntity.getAddress());
        Assertions.assertEquals(testHotelEntity.getName(), hotelEntity.getName());
        Assertions.assertEquals(testHotelEntity.getPhoneNumber(), hotelEntity.getPhoneNumber());
    }

}
