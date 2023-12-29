package com.cowaine.corock.chapter08.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomReserveService {

    @Transactional
    public Boolean reserveRoomById(Long roomId) {
        // (...)
        return false;
    }

}
