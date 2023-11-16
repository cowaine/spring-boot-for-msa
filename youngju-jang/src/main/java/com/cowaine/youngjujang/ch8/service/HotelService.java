package com.cowaine.youngjujang.ch8.service;

import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomType;
import com.cowaine.youngjujang.ch8.controller.HotelCreateRequest;
import com.cowaine.youngjujang.ch8.controller.HotelCreateResponse;
import com.cowaine.youngjujang.ch8.domain.HotelEntity;
import com.cowaine.youngjujang.ch8.domain.HotelRoomEntity;
import com.cowaine.youngjujang.ch8.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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
          ); // hotelEntity : 비영속상태
          
          int roomCount = createRequest.getRoomCount();
          List<HotelRoomEntity> hotelRoomEntities = IntStream.range(0, roomCount) //roomCount 개수만큼 hotelRoomEntities 생성
               .mapToObj(i -> HotelRoomEntity.of("ROOM-" + i, HotelRoomType.DOUBLE,
                    BigDecimal.valueOf(100)))
               .collect(Collectors.toList());
          hotelEntity.addHotelRooms(hotelRoomEntities); // addHotelRooms 으로 HotelRoomEntity가 hotelEntity 객체에 포함됨
          
          // insert 있으므로 readOnly False
          hotelRepository.save(hotelEntity); // 저장후 // hotelEntity : 영속상태로 변경됨, 트잭종료시 hotelEntity, hotelRoomEntities 모두 디비저장
          // @OneToMany(cascade = CascadeType.PERSIST) PERSIST설정 없었다면 HotelRoomEntity 리스트는 저장안됐음
          
          // ch9 - 599p
          // afterCommit() > Transaction 과 Rest-Api 분리
          TransactionSynchronizationManager.registerSynchronization(
               new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
                         super.afterCommit(); // 호텔API커밋 후에 Billing API에 데이터 동기화(마이크로 배치 사용)
                         billingApiAdapter.registerHotelCode(hotelEntity.getHotelId());
                    }
               }
          );
          
          return HotelCreateResponse.of(hotelEntity.getHotelId());
     }
     
   
}
