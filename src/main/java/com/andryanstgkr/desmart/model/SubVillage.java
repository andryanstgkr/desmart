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
@Table(name = "subvillage")
@Access(value = AccessType.FIELD)
public class SubVillage extends BaseEntity{
   
   @Column(name = "name", length = 20, nullable = false)
   private String name;

}
