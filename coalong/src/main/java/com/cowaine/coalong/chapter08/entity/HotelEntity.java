package com.cowaine.coalong.chapter08.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "hotels")
public class HotelEntity {
    @Id
    private Long id;
    private String name;
    private String address;
}