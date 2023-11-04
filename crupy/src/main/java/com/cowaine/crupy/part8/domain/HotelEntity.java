package com.cowaine.crupy.part8.domain;

import com.cowaine.crupy.part8.domain.converter.HotelStatusConverter;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "hotels",
        indexes = @Index(name = "INDEX_NAME_STATUS",
                columnList = "name asc, status asc"))
public class HotelEntity extends AbstractManageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "status")
    @Convert(converter = HotelStatusConverter.class)
    private HotelStatus status;

    @Column
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

    public static HotelEntity of(String name, String address, String phoneNumber) {
        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.name = name;
        hotelEntity.status = HotelStatus.READY;
        hotelEntity.address = address;
        hotelEntity.phoneNumber = phoneNumber;
        hotelEntity.roomCount = 0;
        return hotelEntity;
    }
}
