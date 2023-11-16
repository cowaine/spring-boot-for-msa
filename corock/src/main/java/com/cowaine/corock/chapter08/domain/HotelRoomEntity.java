package com.cowaine.corock.chapter08.domain;

import com.cowaine.corock.chapter08.domain.converter.HotelRoomTypeConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "hotel_rooms")
@Entity(name = "hotelRooms")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class HotelRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_room_no")
    private Long hotelRoomId;

    @Column(name = "hotels_hotel_no")
    private Long hotelId;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "room_type")
    @Convert(converter = HotelRoomTypeConverter.class)
    private HotelRoomType roomType;

    @Column(name = "original_price")
    private BigDecimal originalPrice;

    @Builder(access = AccessLevel.PRIVATE)
    private HotelRoomEntity(String roomNumber, HotelRoomType roomType, BigDecimal originalPrice) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.originalPrice = originalPrice;
    }

    public static HotelRoomEntity of(String roomNumber, HotelRoomType hotelRoomType, BigDecimal originalPrice) {
        return HotelRoomEntity.builder()
                .roomNumber(roomNumber)
                .roomType(hotelRoomType)
                .originalPrice(originalPrice)
                .build();
    }

}
