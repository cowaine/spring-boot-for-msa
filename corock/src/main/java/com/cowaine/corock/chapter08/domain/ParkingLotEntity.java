package com.cowaine.corock.chapter08.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParkingLotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_lot_no")
    private Long id;

    @Column(name = "hotel_no")
    private Long hotelId;

}
