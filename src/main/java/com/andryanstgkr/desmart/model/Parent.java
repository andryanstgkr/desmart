package com.andryanstgkr.desmart.model;

import java.time.LocalDate;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
