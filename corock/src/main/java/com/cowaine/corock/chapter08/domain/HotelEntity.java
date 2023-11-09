package com.cowaine.corock.chapter08.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "hotels")
// @Table(name = "hotels", indexes = @Index(name = "INDEX_NAME_STATUS", columnList = "name asc, status asc"))
@Entity(name = "hotels")
@Getter
public class HotelEntity extends AbstractManageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotelId;

    // @Enumerated(EnumType.STRING)
    @Convert(converter = HotelStatusConverter.class)
    @Column
    private HotelStatus status;

    @Column(nullable = false, length = 300)
    private String name;

    @Column
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "room_count")
    private Integer roomCount;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hotels_hotel_id", referencedColumnName = "hotel_id")
    private List<HotelRoomEntity> hotelRoomEntities;

    protected HotelEntity() {
        super();
    }

    @Builder(access = AccessLevel.PRIVATE)
    private HotelEntity(HotelStatus status, String name, String address, String phoneNumber, Integer roomCount) {
        this.status = status;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.roomCount = roomCount;
    }

    public static HotelEntity of(String name, String address, String phoneNumber) {
        return HotelEntity.builder()
                .name(name)
                .status(HotelStatus.READY)
                .address(address)
                .phoneNumber(phoneNumber)
                .roomCount(0)
                .build();
    }

    public void addHotelRooms(List<HotelRoomEntity> hotelRoomEntities) {
        this.roomCount += hotelRoomEntities.size();
        this.hotelRoomEntities.addAll(hotelRoomEntities);
    }

}

