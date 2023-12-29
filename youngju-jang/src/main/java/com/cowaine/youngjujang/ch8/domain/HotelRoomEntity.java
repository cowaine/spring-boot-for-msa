package com.cowaine.youngjujang.ch8.domain;

import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity (name = "hotelRooms")
@Table (name = "hotel_rooms") // db table 명
public class HotelRoomEntity {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "hotel_room_id")
     private Long hotelRoomId;
     
     @ManyToOne
     @JoinColumn(name = "hotel_id", nullable = true)
     private HotelEntity hotelEntity;
     
     @Column(name = "hotels_hotel_id")
     private Long hotelId;
     
     @Column(name = "room_number")
     private String roomNumber;
     
     @Column(name = "room_type")
//     @Convert(converter = HotelRoomTypeConverter.class)
     private HotelRoomType roomType;
     
     @Column(name = "original_price")
     private BigDecimal originalPrice;
     
     public void setHotelEntity(HotelEntity hotelEntity){
          this.hotelEntity = hotelEntity;
     }
     public static HotelRoomEntity of(String roomNumber, HotelRoomType hotelRoomType, BigDecimal originalPrice) {
          HotelRoomEntity hotelRoomEntity = new HotelRoomEntity();
          hotelRoomEntity.roomNumber = roomNumber;
          hotelRoomEntity.roomType = hotelRoomType;
          hotelRoomEntity.originalPrice = originalPrice;
          return hotelRoomEntity;
     }
}
