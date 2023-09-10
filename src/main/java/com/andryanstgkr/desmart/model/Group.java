package com.andryanstgkr.desmart.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Data
@Component
public class Group extends BaseEntity{

   @Column(name = "name", length = 50, nullable = false)
   private String name;

   @Column(name= "description", length = 1000, nullable = true)
   private String description;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "organization_id")
   private Organization parenOrganization;
}
