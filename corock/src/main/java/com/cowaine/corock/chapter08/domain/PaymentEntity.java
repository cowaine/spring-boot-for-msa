package com.cowaine.corock.chapter08.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentEntity {

    @Id
    @Column(name = "payment_no")
    private Long paymentId;

    // (...)

}
