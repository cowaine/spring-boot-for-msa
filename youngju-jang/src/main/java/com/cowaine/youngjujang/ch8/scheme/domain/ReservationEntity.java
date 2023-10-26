package com.cowaine.youngjujang.ch8.scheme.domain;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "reservations")
public class ReservationEntity {
     // 임시 클래스
     
     @Id // 클래스 기본키 설정
     @Column (name = "reserve_id")
     private Long reserveId;
     
     @Column (name = "resserved_date")
     @Temporal (value = TemporalType.DATE)
     private Date reservedDate;
     
     //TemporalType.Date : 'yyyy-MM-dd'
     //TemporalType.TIME : 'HH:mm:ss'
     //TemporalType.TIMESTAMP : 'yyyy-MM-dd HH:mm:ss
     
}
