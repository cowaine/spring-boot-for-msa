package com.cowaine.youngjujang.ch8.domain;

import com.cowaine.youngjujang.ch8.domain.converter.HotelStatusConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "hotels") // 객체명(쿼리용)
//@NoArgsConstructor // 기본생성자 반드시 필요
@Table (name = "hotels", indexes = @Index (name = "INDEX_NAME_STATUS", columnList = "name asc, status asc"))
public class HotelEntity extends AbstractManageEntity {
     
     @Id // 클래스 기본키 설정
     @GeneratedValue (strategy = GenerationType.IDENTITY) // 자동증가 기능
     @Column (name = "hotel_id")
     private Long hotelId;
     
     @Column (name = "status")
     @Convert(converter = HotelStatusConverter.class)
     private HotelStatus status;
     
     // ddl-auto: create 이었을경우 아래처럼 컬럼 추가정의 필요
     @Column(name = "name", nullable = false, length = 300)
     private String name;
     
     @Column
     private String address;
     
     @Column (name = "phone_number")
     private String phoneNumber;
     
     @Column (name = "room_count")
     private Integer roomCount;
     
     // OneToMany FetchType : 기본값 :LAZY , orphanRemoval : 기본 false >> true 일 경우 HotelRoomRepository를 사용한 delete 가 아니더라도 객체삭제시 삭제됨
     @OneToMany(mappedBy = "hotelEntity", cascade = CascadeType.PERSIST, orphanRemoval = true) // 연관관계 설정해야 오류안뜸 // cascade : 영속성전이 단계 설정
     @JoinColumn(name = "hotels_hotel_id", referencedColumnName = "hotel_id") // fk : hotels_hotel_id => hotel table 의 hotel_id.
     private List<HotelRoomEntity> hotelRoomEntities;
     
     public HotelEntity() {
          super();
          this.hotelRoomEntities = new ArrayList<>();
     }
     
     public static HotelEntity of(String name,
                                  String address,
                                  String phoneNumber){
          HotelEntity hotelEntity = new HotelEntity();
          hotelEntity.name = name;
          hotelEntity.status = HotelStatus.READY;
          hotelEntity.address = address;
          hotelEntity.phoneNumber = phoneNumber;
          hotelEntity.roomCount = 0;
          return hotelEntity;
     }
     
     public void addRoom(HotelRoomEntity hotelRoomEntity){
          hotelRoomEntity.setHotelEntity(this);
          this.hotelRoomEntities.add(hotelRoomEntity);
     }
     
     public void addHotelRooms(List<HotelRoomEntity> hotelRoomEntities) {
          this.roomCount += hotelRoomEntities.size();
          hotelRoomEntities.stream()
               .peek(room -> room.setHotelEntity(this))
               .close();
          this.hotelRoomEntities.addAll(hotelRoomEntities);
     }
}
