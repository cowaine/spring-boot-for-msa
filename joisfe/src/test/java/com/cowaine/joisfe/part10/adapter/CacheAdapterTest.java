package com.cowaine.joisfe.part10.adapter;

import com.cowaine.joisfe.part10.adapter.cache.CacheAdapter;
import com.cowaine.joisfe.part10.adapter.cache.HotelCacheKey;
import com.cowaine.joisfe.part10.adapter.cache.HotelCacheValue;
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
    @DisplayName("케시에서 데이터를 불러온다")
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
