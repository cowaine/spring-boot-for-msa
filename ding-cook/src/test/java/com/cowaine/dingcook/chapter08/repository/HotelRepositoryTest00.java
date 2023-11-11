//package com.cowaine.dingcook.chapter08.repository;
//
//import com.cowaine.dingcook.chapter08.domain.HotelEntity;
//import com.cowaine.dingcook.chapter08.domain.HotelStatus;
//import javax.transaction.Transactional;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//
//@SpringBootTest
//@Transactional
//@TestPropertySource(locations = "classpath:application-test.properties")
//class HotelRepositoryTest00 {
//
//    private static HotelEntity testHotelEntity;
//
//    @Autowired
//    private HotelRepository hotelRepository;
//
//    @BeforeEach
//    public void init() {
//        testHotelEntity = HotelEntity.of("The LINE LA", "3515 Wilshire Blvd, Los Angeles, CA 90010",
//            "+12133817411", 100);
//    }
//
//    @Test
//    void testFindByStatus() {
//
//        // Given
//        hotelRepository.save(testHotelEntity);
//
//        // WHEN
//        HotelEntity hotelEntity =
//            hotelRepository.findByStatus(HotelStatus.READY).stream().filter(entity -> entity.getHotelId().equals(testHotelEntity.getHotelId()))
//                .findFirst().get();
//
//        // Then
//        Assertions.assertNotNull(hotelEntity);
//        Assertions.assertEquals(testHotelEntity.getAddress(), hotelEntity.getAddress());
//        Assertions.assertEquals(testHotelEntity.getName(), hotelEntity.getName());
//        Assertions.assertEquals(testHotelEntity.getPhoneNumber(), hotelEntity.getPhoneNumber());
//    }
//}