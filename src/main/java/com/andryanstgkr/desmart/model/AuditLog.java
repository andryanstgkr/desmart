package com.andryanstgkr.desmart.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "audit_log")
@Access(value = AccessType.FIELD)
public class AuditLog  extends  BaseEntity{
    @Column(name = "action_type", length = 100)
    private String actionType;

    @Column(name = "action_by", length = 100)
    private String actionBy = "admin";

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "error_message", length = 4000)
    private String error;
}
