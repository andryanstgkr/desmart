package com.andryanstgkr.desmart.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import java.time.LocalDate;

@Component
@Data
@Entity
@Table(name = "parents")
@Access(value = AccessType.FIELD)
public class Parent extends BaseEntity {
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "husband_id")
   private Resident husband;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "wife_id")
   private Resident wife;

   @Column(name = "marriage_date", nullable = false)
   private LocalDate marriageDate;

   @Column(name = "divorce_date", nullable = true)
   private LocalDate divorceDate;
}
