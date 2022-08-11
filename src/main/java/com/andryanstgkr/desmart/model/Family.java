package com.andryanstgkr.desmart.model;

import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
