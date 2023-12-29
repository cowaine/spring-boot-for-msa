package com.cowaine.corock.chapter08.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "reservations")
@Entity
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_no")
    private Long reservationId;

    @Column(name = "reserved_at")
    @Temporal(value = TemporalType.DATE)
    private Date reservedDate;

    @ManyToMany
    @JoinTable(name = "reservations_payments_map",
               joinColumns = @JoinColumn(name = "reservation_no"),
               inverseJoinColumns = @JoinColumn(name = "payment_no"))
    private List<PaymentEntity> paymentEntities = new ArrayList<>();

}
