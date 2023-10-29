package com.cowaine.coalong.chapter08.domain;

import com.cowaine.coalong.chapter08.server.UserIdHolder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@Slf4j
@MappedSuperclass
@Getter
public class AbstractManageEntity {

    @Column(name = "created_at")
    private ZonedDateTime createdDate;

    @Column(name = "create_by")
    private String createdBy;

    @Column(name = "modified_at")
    private ZonedDateTime modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    public AbstractManageEntity() {
        this.createdDate = ZonedDateTime.now();
        this.createdBy = UserIdHolder.getUserId();
    }

}
