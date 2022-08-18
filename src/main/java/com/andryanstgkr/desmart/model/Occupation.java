package com.andryanstgkr.desmart.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
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
