package com.cowaine.youngjujang.ch5.domain.model;

import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomResponse;
import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomType;
import com.cowaine.youngjujang.ch5.domain.utils.ToDollarStringSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class HotelRoom {
     @Id
     private Long id;
     private String roomNumber;
     private int numberOfBeds;
     private HotelRoomType roomType; // enum type
     private BigDecimal originalPrice;
//     private List<HotelRoomResponse.Reservation> reservations;
}
