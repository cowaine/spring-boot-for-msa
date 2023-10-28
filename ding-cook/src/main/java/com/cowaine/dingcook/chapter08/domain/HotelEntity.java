package com.cowaine.dingcook.chapter08.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "hotels", indexes = @Index(name = "INDEX_NAME_STATUS", columnList = "name asc, status"))
public class HotelEntity extends AbstractManageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    @Column(name = "status")
    private HotelStatus status;

    @Column(name = "name", nullable = false, length = 300)
    private String name;

    @Column
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "room_count")
    private Integer roomCount;

    public HotelEntity() {
        super();
    }

    public static HotelEntity of(String name, String address, String phoneNumber, Integer roomCount) {
        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.name = name;
        hotelEntity.status = HotelStatus.READY;
        hotelEntity.address = address;
        hotelEntity.phoneNumber = phoneNumber;
        hotelEntity.roomCount = roomCount;

        return hotelEntity;
    }
}
