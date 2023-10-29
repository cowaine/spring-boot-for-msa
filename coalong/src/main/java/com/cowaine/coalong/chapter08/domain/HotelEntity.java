package com.cowaine.coalong.chapter08.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "hotels", indexes = @Index(name =
        "INDEX_NAME_STATUS", columnList = "name asc, status asc"))
@NoArgsConstructor
public class HotelEntity extends AbstractManageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotel_id;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private HotelStatus status;

    @Column
    private String name;

    @Column
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "room_count")
    private Integer roomCount;

    @Builder(access = AccessLevel.PRIVATE)
    private HotelEntity(HotelStatus status, String name, String address, String phoneNumber, Integer roomCount) {
        super();
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
