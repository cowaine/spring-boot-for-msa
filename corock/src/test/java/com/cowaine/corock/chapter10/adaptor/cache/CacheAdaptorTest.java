package com.cowaine.corock.chapter10.adaptor.cache;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CacheAdaptorTest {

    @Autowired
    CacheAdaptor cacheAdaptor;

    @DisplayName("캐시에서 데이터를 불러온다")
    @Test
    void testGetOperation() {
        // Given
        HotelCacheKey key = HotelCacheKey.from(1234567890L);
        HotelCacheValue value = HotelCacheValue.of("Line", "LA");
        cacheAdaptor.put(key, value);

        // When
        HotelCacheValue result = cacheAdaptor.get(key);

        // Then
        assertEquals(value, result);
    }

    @DisplayName("캐시에서 데이터를 삭제한다")
    @Test
    void testDeleteOperation() {
        // Given
        HotelCacheKey key = HotelCacheKey.from(1234567890L);
        HotelCacheValue value = HotelCacheValue.of("Line", "LA");
        cacheAdaptor.put(key, value);

        // When
        cacheAdaptor.delete(key);

        // Then
        HotelCacheValue result = cacheAdaptor.get(key);
        assertNull(result);
    }

}
