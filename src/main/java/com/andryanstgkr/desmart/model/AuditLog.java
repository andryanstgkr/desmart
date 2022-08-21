package com.andryanstgkr.desmart.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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