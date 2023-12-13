package com.coffee.system.config;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class SysAuditing {
	@Column(name = "created_date", nullable = true, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date",nullable = true)
    @LastModifiedDate
    private long modifiedDate;

	@Column(name = "created_by",  nullable = true)
    @CreatedBy
    private String createdBy;
    
	@Column(name = "modified_by" ,nullable = true)
    @LastModifiedBy
    private String modifiedBy;
}
