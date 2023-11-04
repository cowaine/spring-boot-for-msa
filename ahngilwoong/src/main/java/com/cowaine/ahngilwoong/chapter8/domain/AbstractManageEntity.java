package com.cowaine.ahngilwoong.chapter8.domain;

import com.cowaine.ahngilwoong.chapter8.server.UserIdHolder;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MappedSuperclass
@Getter
public abstract class AbstractManageEntity {

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_at")
    private ZonedDateTime modifiedAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    public AbstractManageEntity() {
        this.createdAt = ZonedDateTime.now();
        this.createdBy = UserIdHolder.getUserId();
    }
}
