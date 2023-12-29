package com.cowaine.joisfe.part8.domain;

import com.cowaine.joisfe.part8.converter.HotelStatusConverter;
import com.cowaine.joisfe.part8.service.HotelAuditListener;
import java.util.ArrayList;
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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
@Entity(name = "hotels")
@Table(name = "hotels", indexes = @Index(name = "INDEX_NAME_STATUS", columnList = "name asc, status asc"))
@EntityListeners(HotelAuditListener.class)
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

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hotels_hotel_id", referencedColumnName = "hotel_id")
    private List<HotelRoomEntity> hotelRoomEntities;

    public HotelEntity() {
        super();
        this.hotelRoomEntities = new ArrayList<>();
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
