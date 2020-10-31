package com.backend.apiserver.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * Class using to add more information to entity if needed
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;


    @CreatedDate
    @Column(name = "created_date", updatable = false, columnDefinition = "TIMESTAMP")
    private OffsetDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;


    @LastModifiedDate
    @Column(name = "last_modified_date", columnDefinition = "TIMESTAMP")
    private OffsetDateTime lastModifiedDate;

    private void test(){
        OffsetDateTime.now();
    }
}
