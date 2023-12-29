package com.cowaine.corock.chapter10.adaptor.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class EventTest {

    @Autowired
    EventPublisher eventPublisher;

    @Test
    void testPubSub() throws InterruptedException {
        eventPublisher.sendMessage(new EventMessage("test"));
        TimeUnit.SECONDS.sleep(3L);
    }

}
