package com.cowaine.dingcook;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MiscTest {

    @BeforeAll
    public static void setup() {
        System.out.println("셋업");
    }

    @BeforeEach
    public void init() {
        System.out.println("인잇");
    }

    @Test
    public void testHashSetContainsNonDuplicatedValue() {

        //Given
        var value = Integer.valueOf(1);
        Set<Integer> set = new HashSet<>();

        //WHEN
        set.add(value);
        set.add(value);
        set.add(value);

        //TEHN
        Assertions.assertEquals(1, set.size());
        Assertions.assertTrue(set.contains(value));
    }

    @Test
    public void testDummy() {
        Assertions.assertTrue(Boolean.TRUE);
    }

    @AfterEach
    public void cleanup() {
        System.out.println("클린 업");
    }

    @AfterAll
    public static void destroy() {
        System.out.println("디스트로이");
    }

    @Test
    @DisplayName("Assertions 예외 검증 테스트")
    public void testInputOutputException() {
        Object input = null;
        Object output = null;

        // 책 코드
//        Assertions.assertThrows(IOException.class, () -> IOUtils.copy((InputStream) input, (OutputStream) output));

        // 내 코드
        Assertions.assertThrows(NullPointerException.class,
            () -> IOUtils.copy((InputStream) input, (OutputStream) output));
    }
}
