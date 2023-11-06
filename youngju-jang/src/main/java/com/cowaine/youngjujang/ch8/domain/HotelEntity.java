package com.cowaine.youngjujang.ch8.domain;

import com.cowaine.youngjujang.ch8.domain.converter.HotelStatusConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "hotels")
@NoArgsConstructor // 기본생성자 반드시 필요
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
}
