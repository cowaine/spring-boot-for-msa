package com.cowaine.youngjujang.ch8.domain;

import javax.persistence.*;

@Entity (name = "hotelRooms")
@Table (name = "hotel_rooms") // db table 명
public class HotelRoomEntity {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "hotel_room_id")
     private Long hotelRoomId;
     
     @ManyToOne
     private HotelEntity hotelEntity;
}
