package com.cowaine.youngjujang.ch8.service;

import com.cowaine.youngjujang.ch8.controller.HotelCreateRequest;
import com.cowaine.youngjujang.ch8.controller.HotelCreateResponse;
import com.cowaine.youngjujang.ch8.domain.HotelEntity;
import com.cowaine.youngjujang.ch8.domain.HotelRoomEntity;
import com.cowaine.youngjujang.ch8.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
     
     // 연관관계 적용하여 HotelRoomRepository 접근없이도 HotelRoomEntity 참조가능
     public void readHotelRoomWithoutHotelRomeRepository(){
          Long hotelId = 1L;
          HotelEntity hotelEntity = hotelRepository.findById(hotelId).orElseThrow();
          List<HotelRoomEntity> hotelRoomEntities = hotelEntity.getHotelRoomEntities();
     }
}
