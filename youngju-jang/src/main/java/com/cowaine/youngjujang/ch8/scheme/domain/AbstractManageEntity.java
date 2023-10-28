package com.cowaine.youngjujang.ch8.scheme.domain;

import com.cowaine.youngjujang.ch8.scheme.server.UserIdHoder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@Slf4j
@Getter
@MappedSuperclass // 자식 엔티티클래스가 상속할 수 있도록 정의. 코드중복 줄여줌. 캡슐화bb
public abstract class AbstractManageEntity { // 단독매핑될 테이블 없음. abstract로 단독 생성되지 않도록 함
     
     @Column(name = "created_at")
     private ZonedDateTime createdAt;
     
     @Column(name = "created_by")
     private String createdBy;
     
     @Column(name = "modified_at")
     private ZonedDateTime modifiedAt;
     
     @Column(name = "modified_by")
     private String modifiedBy;
     
     public AbstractManageEntity() { // insert할때 생성한 시간과 사람을 입력하도록 함
          this.createdAt = ZonedDateTime.now(); // 객체가 생성된 시간과
          this.createdBy = UserIdHoder.getUserId(); // 유저 아이디를 입력함
     }
}
