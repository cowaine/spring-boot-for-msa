package com.cowaine.corock.chapter10.adaptor.rank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BiddingAdaptorTest {

    final Long firstUserId = 1L;
    final Long secondUserId = 2L;
    final Long thirdUserId = 3L;
    final Long fourthUserId = 4L;
    final Long fifthUserId = 5L;
    final Long hotelId = 1_000L;

    @Autowired
    BiddingAdaptor biddingAdaptor;

    @Test
    void simulate() {
        biddingAdaptor.clear(hotelId);

        biddingAdaptor.createBidding(hotelId, firstUserId, 100d);
        biddingAdaptor.createBidding(hotelId, secondUserId, 110d);
        biddingAdaptor.createBidding(hotelId, thirdUserId, 120d);
        biddingAdaptor.createBidding(hotelId, fourthUserId, 130d);
        biddingAdaptor.createBidding(hotelId, fifthUserId, 140d);

        biddingAdaptor.createBidding(hotelId, secondUserId, 150d);
        biddingAdaptor.createBidding(hotelId, firstUserId, 200d);

        List<Long> topBidders = biddingAdaptor.getTopBidders(hotelId, 3);

        assertEquals(firstUserId, topBidders.get(0));
        assertEquals(secondUserId, topBidders.get(1));
        assertEquals(fifthUserId, topBidders.get(2));

        assertEquals(200d, biddingAdaptor.getBidAmount(hotelId, firstUserId));
        assertEquals(150d, biddingAdaptor.getBidAmount(hotelId, secondUserId));
        assertEquals(140d, biddingAdaptor.getBidAmount(hotelId, fifthUserId));
    }

}
