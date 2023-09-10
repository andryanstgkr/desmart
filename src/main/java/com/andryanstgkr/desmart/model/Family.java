package com.andryanstgkr.desmart.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import java.util.List;

@Component
@Data
@Entity
@Table(name = "families")
@Access(value = AccessType.FIELD)
public class Family extends BaseEntity{

   @Column(name = "family_ic_no", length = 50, nullable = false, unique = true)
   private String familyIcNo;

   @Column(name = "family_name", length = 50)
   private String name;

   @OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "parent_id")
   private Parent parent;
   
   @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
   private List<Resident> children;

}
