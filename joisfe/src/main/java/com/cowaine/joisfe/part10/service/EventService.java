package com.cowaine.joisfe.part10.service;

import com.cowaine.joisfe.part10.adapter.lock.LockAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
//@Service
public class EventService {

//    @Autowired
//    private LockAdapter lockAdapter;
//
//    @Transactional(timeout = 10)
//    public Boolean attendEvent(Long hotelId, Long userId) {
//
//        if (!lockAdapter.holdLock(hotelId, userId)) {
//            return Boolean.FALSE;
//        }
//    }
}
