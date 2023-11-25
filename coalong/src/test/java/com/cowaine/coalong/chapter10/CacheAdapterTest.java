package com.cowaine.coalong.chapter10;

import com.cowaine.coalong.chapter10.adapter.CacheAdapter;
import com.cowaine.coalong.chapter10.cache.HotelCacheKey;
import com.cowaine.coalong.chapter10.cache.HotelCacheValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheAdapterTest {

    @Autowired
    private CacheAdapter cacheAdapter;

    @Test
    @DisplayName("캐시에서 데이터를 불러온다")
    public void testGetOperation() {

        // GIVEN
        HotelCacheKey key = HotelCacheKey.from(1234567890L);
        HotelCacheValue value = HotelCacheValue.of("Line", "LA");
        cacheAdapter.put(key, value);

        // WHEN
        HotelCacheValue result = cacheAdapter.get(key);

        // THEN
        Assertions.assertEquals(value, result);
    }

    @Test
    @DisplayName("케시에서 데이터를 삭제한다")
    public void testDeleteOperation() {

        // GIVEN
        HotelCacheKey key = HotelCacheKey.from(1234567890L);
        HotelCacheValue value = HotelCacheValue.of("Line", "LA");
        cacheAdapter.put(key, value);

        // WHEN
        cacheAdapter.delete(key);

        // THEN
        HotelCacheValue result = cacheAdapter.get(key);
        Assertions.assertNull(result);
    }
}

