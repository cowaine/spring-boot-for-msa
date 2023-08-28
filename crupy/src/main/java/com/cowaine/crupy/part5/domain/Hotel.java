package com.cowaine.crupy.part5.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Hotel {
    private String id;
    private String roomNumber;
    private int numberOfBeds;
    private String roomType;
    private String originalPrice;
    private List<RoomReservation> reservations;
}
