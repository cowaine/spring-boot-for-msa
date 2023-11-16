package com.cowaine.dingcook.chapter08.domain;

import com.cowaine.dingcook.chapter08.domain.converter.HotelStatusConverter;
import com.cowaine.dingcook.chapter08.service.HotelEntityListener;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import lombok.Getter;

@Getter
@Entity(name = "hotels")
@Table(name = "hotels", indexes = @Index(name = "INDEX_NAME_STATUS", columnList = "name asc, status"))
@EntityListeners(HotelEntityListener.class)
public class HotelEntity extends AbstractManageEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sequenceGenerator")
//    @TableGenerator(
//        name = "sequenceGenerator",
//        table = "TBL_SEQENCES",
//        pkColumnName = "SEQUENCE_NAME",
//        pkColumnValue="HOTEL_SEQUENCE",
//        valueColumnName="SEQUENCE_VALUE",
//        initialValue=10000, allocationSize=100
//    )
//    @Column(name = "hotel_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long hotelId;

    @Column(name = "status")
//    @Enumerated(value= EnumType.STRING)
    @Convert(converter = HotelStatusConverter.class)
    private HotelStatus status;

    @Column(name = "name", nullable = false, length = 300)
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

    public void addHotelRooms(List<HotelRoomEntity> hotelRoomEntities) {
        this.roomCount += hotelRoomEntities.size();
        this.hotelRoomEntities.addAll(hotelRoomEntities);
    }
}
