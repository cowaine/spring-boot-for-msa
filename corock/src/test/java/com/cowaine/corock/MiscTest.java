package com.cowaine.corock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.HashSet;

@Slf4j
class MiscTest {

    @BeforeAll
    static void beforeAll() {
        log.info("before all tests in the current test class");
    }

    @BeforeEach
    void setUp() {
        log.info("before each @Test");
    }

    @DisplayName("HashSet 객체에 요소를 추가할 때 중복된 요소는 객체에 중복 저장하지 않는다.")
    @Test
    void testHashSerContainsNonDuplicatedValue() {
        // Given
        Integer value = 1;
        HashSet<Integer> set = new HashSet<>();

        // When
        set.add(value);
        set.add(value);
        set.add(value);

        // Then
        Assertions.assertEquals(1, set.size());
        Assertions.assertTrue(set.contains(value));

        // Assertions.assertThrows(IOException.class, () -> IOUtils.copy(input, output));
    }

    @AfterEach
    void tearDown() {
        log.info("after each @Test");
    }

    @AfterAll
    static void afterAll() {
        log.info("after all tests in the current test class");
    }

}
