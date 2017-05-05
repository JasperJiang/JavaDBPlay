package com.jasper.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by jjiang153 on 2017/5/5.
 */

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {

    @CreatedDate
    @NotNull
    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    @NotNull
    private LocalDateTime lastModifiedDate = LocalDateTime.now();
}
