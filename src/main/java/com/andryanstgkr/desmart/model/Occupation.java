package com.andryanstgkr.desmart.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "occupations")
@Access(value = AccessType.FIELD)
public class Occupation extends BaseEntity {
   @Column(name="name", length = 30, nullable = false)
   private String name;

   @Column(name="description", length = 1000, nullable = true)
   private String description;
}
