package com.cowaine.joisfe;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MiscTest {

    @BeforeAll
    public static void setup() {
        System.out.println("before all tests in the current test class");
    }

    @AfterAll
    public static void destory() {
        System.out.println("after all tests in the current test class");
    }

    @BeforeEach
    public void init() {
        System.out.println("before each @Test");
    }

    @Test
    public void testHashSetContainsNonDuplicatedValue() {

        // Given
        Integer value = Integer.valueOf(1);
        Set<Integer> set = new HashSet<>();

        // When
        set.add(value);
        set.add(value);
        set.add(value);

        // Then
        Assertions.assertEquals(1, set.size());
        Assertions.assertTrue(set.contains(value));
    }

    @Test
    public void testDummy() {
        Assertions.assertTrue(Boolean.TRUE);
    }

    @AfterEach
    public void cleanup() {
        System.out.println("after each @Test");
    }
}
