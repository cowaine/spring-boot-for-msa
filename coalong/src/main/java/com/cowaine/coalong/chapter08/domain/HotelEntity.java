package com.cowaine.coalong.chapter08.domain;

import com.cowaine.coalong.chapter08.domain.converter.HotelStatusConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "hotels") /* createQuery 메소드에서는 테이블명이 아닌 Entity 클래스명으로 찾는다. */
@Table(name = "hotels", indexes = @Index(name = "INDEX_NAME_STATUS", columnList = "name asc, status asc"))
@NoArgsConstructor
public class HotelEntity extends AbstractManageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotel_id;

    // @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    // 만약 전역 설정 안했다면 아래와 같이 명시적으로 컨버터 지정하여 사용
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
