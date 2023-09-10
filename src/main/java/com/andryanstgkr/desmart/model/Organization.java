package com.andryanstgkr.desmart.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Data
@Entity
@Table(name = "organizations")
@Access(value = AccessType.FIELD)
public class Organization extends BaseEntity{
   @Column(name="name", length = 50, nullable = false)
   private String name;

   @Column(name="description", length = 1000, nullable = true)
   private String description;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "organization_id")
   private Organization parenOrganization;
}
