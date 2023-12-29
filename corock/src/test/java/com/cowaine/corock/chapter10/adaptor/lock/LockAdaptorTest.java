package com.cowaine.corock.chapter10.adaptor.lock;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LockAdaptorTest {

    final Long firstUserId = 1L;
    final Long secondUserId = 2L;
    final Long thirdUserId = 3L;

    @Autowired
    LockAdaptor lockAdaptor;

    @DisplayName("firstUserId 가 락을 선점한다.")
    @Test
    void testLock() {
        final Long hotelId = 123_123_123L;

        Boolean isSuccess = lockAdaptor.holdLock(hotelId, firstUserId);
        assertTrue(isSuccess);

        isSuccess = lockAdaptor.holdLock(hotelId, secondUserId);
        assertFalse(isSuccess);

        isSuccess = lockAdaptor.holdLock(hotelId, thirdUserId);
        assertFalse(isSuccess);

        Long holderId = lockAdaptor.checkLock(hotelId);
        assertEquals(firstUserId, holderId);
    }

    @DisplayName("3명이 동시에 락을 선점하지만 1명만 락을 잡는다.")
    @Test
    void testConcurrentAccess() throws InterruptedException {
        final Long hotelId = 9_999_999L;
        lockAdaptor.clearLock(hotelId);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(new Accessor(hotelId, firstUserId, cyclicBarrier)).start();
        new Thread(new Accessor(hotelId, firstUserId, cyclicBarrier)).start();
        new Thread(new Accessor(hotelId, firstUserId, cyclicBarrier)).start();
        TimeUnit.SECONDS.sleep(1);

        Long holderId = lockAdaptor.checkLock(hotelId);
        assertTrue(List.of(firstUserId, secondUserId, thirdUserId).contains(holderId));

        lockAdaptor.clearLock(hotelId);
    }

    @AllArgsConstructor
    class Accessor implements Runnable {

        private Long hotelId;
        private Long userId;
        private CyclicBarrier cyclicBarrier;

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                lockAdaptor.holdLock(hotelId, userId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

}