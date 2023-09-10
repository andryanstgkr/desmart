package com.andryanstgkr.desmart.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Embeddable
@MappedSuperclass
@Data
@ToString
public class BaseEntity {
    @Id
    @ToString.Exclude
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true, length = 50)
    private String id;

    @ToString.Exclude
    @Column(name = "created_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @ToString.Exclude
    @Column(name = "updated_date", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @ToString.Exclude
    @Column(name = "updated_by", length = 100, nullable = true)
    private String updatedBy = "Admin";

    @ToString.Exclude
    @Column(name = "created_by", length = 100, nullable = true)
    private String createdBy = "Admin";

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

}