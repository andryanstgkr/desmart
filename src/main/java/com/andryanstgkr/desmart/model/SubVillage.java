package com.andryanstgkr.desmart.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Data
@Entity
@Table(name = "subvillage")
@Access(value = AccessType.FIELD)
public class SubVillage extends BaseEntity{
   
   @Column(name = "name", length = 20, nullable = false)
   private String name;

}
