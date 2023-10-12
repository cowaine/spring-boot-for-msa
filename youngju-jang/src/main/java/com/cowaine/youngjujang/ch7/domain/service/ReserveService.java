package com.cowaine.youngjujang.ch7.domain.service;

import com.cowaine.youngjujang.ch5.domain.model.HotelRoom;
import com.cowaine.youngjujang.ch5.domain.repository.HotelRoomRepository;
import com.cowaine.youngjujang.ch5.domain.utils.exception.BadRequestException;
import com.cowaine.youngjujang.ch7.aspect.ElapseLoggable;
import com.cowaine.youngjujang.ch7.domain.controller.HotelRequest;
import com.cowaine.youngjujang.ch7.domain.controller.HotelResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReserveService {
     
     @ElapseLoggable // 메서드에 사용가능한 애노테이션임
     public List<HotelResponse> getHotelsByName(HotelRequest hotelRequest){
          log.info("3) getHotelsByName service run");
          return List.of(
               new HotelResponse(1000L,
                    hotelRequest.getHotelName(),
                    "18091 CA-1, San Simeon, CA 93452",
                    "+18885846374"
               ));
     }
}