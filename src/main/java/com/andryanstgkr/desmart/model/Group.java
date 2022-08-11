package com.andryanstgkr.desmart.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Group extends BaseEntity{

   @Column(name = "name", length = 50, nullable = false)
   private String name;

   @Column(name= "description", length = 1000, nullable = true)
   private String description;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "organization_id")
   private Organization parenOrganization;
}
