package com.cowaine.dingcook.chapter10.event;

import com.cowaine.dingcook.chapter10.adapter.event.EventMessage;
import com.cowaine.dingcook.chapter10.adapter.event.EventPublisher;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventTest {

    @Autowired
    private EventPublisher eventPublisher;

    @Test
    public void testPubSub() throws InterruptedException {
        eventPublisher.sendMessage(new EventMessage("test"));
        TimeUnit.SECONDS.sleep(3);
    }
}
