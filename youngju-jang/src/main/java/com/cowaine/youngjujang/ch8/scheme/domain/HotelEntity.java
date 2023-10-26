package com.cowaine.youngjujang.ch8.scheme.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor // 기본생성자 반드시 필요
@Table (name = "hotels", indexes = @Index (name = "INDEX_NAME_STATUS", columnList = "name asc, status asc"))
public class HotelEntity extends AbstractManageEntity {
     
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
     @Column (name = "hotel_id")
     private Long hotelId;
     
     @Column (name = "status")
     private HotelStatus status;
     
     @Column
     private String name;
     
     @Column
     private String address;
     
     @Column (name = "phone_number")
     private String phoneNumber;
     
     @Column (name = "room_count")
     private Integer roomCount;
     
     public static HotelEntity of(String name,
                                  String address,
                                  String phoneNumber,
                                  Integer roomCount){
          HotelEntity hotelEntity = new HotelEntity();
          
          hotelEntity.name = name;
          hotelEntity.status = HotelStatus.READY;
          hotelEntity.address = address;
          hotelEntity.phoneNumber = phoneNumber;
          hotelEntity.roomCount = roomCount;
          
          return hotelEntity;
     }
}
