package com.cowaine.youngjujang.ch8.service;

import com.cowaine.youngjujang.ch8.controller.HotelCreateRequest;
import com.cowaine.youngjujang.ch8.controller.HotelCreateResponse;
import com.cowaine.youngjujang.ch8.domain.HotelEntity;
import com.cowaine.youngjujang.ch8.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class HotelService {
     
     private final HotelRepository hotelRepository;
     
     @Transactional (readOnly = false, isolation = Isolation.SERIALIZABLE)
     public HotelCreateResponse createHotel(HotelCreateRequest createRequest){
          HotelEntity hotelEntity = HotelEntity.of( // request받은값으로 entity 생성하고
               createRequest.getName(),
               createRequest.getAddress(),
               createRequest.getPhoneNumber()
          );
          // insert 있으므로 readOnly False
          hotelRepository.save(hotelEntity); // 저장후
          return HotelCreateResponse.of(hotelEntity.getHotelId());
     }
}
