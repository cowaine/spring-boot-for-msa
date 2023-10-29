package com.cowaine.corock.chapter08.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Table(name = "hotels", indexes = @Index(name = "INDEX_NAME_STATUS", columnList = "name asc, status asc"))
@Entity
@Getter
public class HotelEntity extends AbstractManageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotelId;

    @Enumerated(EnumType.STRING)
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

    public static HotelEntity of(String name, String address, String phoneNumber, Integer roomCount) {
        return HotelEntity.builder()
                .name(name)
                .status(HotelStatus.READY)
                .address(address)
                .phoneNumber(phoneNumber)
                .roomCount(roomCount)
                .build();
    }

}

