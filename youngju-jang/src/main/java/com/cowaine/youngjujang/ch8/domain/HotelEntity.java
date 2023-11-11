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
     
     @OneToMany // 연관관계 설정해야 오류안뜸
     @JoinColumn(name = "hotels_hotel_id", referencedColumnName = "hotel_id") // fk : hotels_hotel_id => hotel table 의 hotel_id.
     private List<HotelRoomEntity> hotelRoomEntities;
     /*
     외래키가 여러개인 복합필드값 사용시 @JoinColumns , @JoinColumn 조합하여 사용가능
     @JoinColumns({
          @JoinColumn(name="head_quater_id", referencedColumnName = "id"),
          @JoinColumn(name="head_quater_name", referencedColumnName = "name")
     })
     */
     
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
}
