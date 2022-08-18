package com.andryanstgkr.desmart.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@Setter
@Entity
@Table(name = "subvillage")
@Access(value = AccessType.FIELD)
public class SubVillage extends BaseEntity{
   
   @Column(name = "name", length = 20, nullable = false)
   private String name;

}
