package com.andryanstgkr.desmart.model;

import java.time.LocalDate;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.andryanstgkr.desmart.enums.GenderEnum;
import com.andryanstgkr.desmart.enums.MarriageEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "residents")
@Access(value = AccessType.FIELD)
public class Resident extends BaseEntity {
   @Column(name = "ic_no", length = 50, nullable = false, unique = true, columnDefinition = "TEXT")
   private String icNo;

   @Column(name = "first_name", length = 50, nullable = false, columnDefinition = "TEXT")
   private String firstName;

   @Column(name = "middle_name", length = 50, nullable = true, columnDefinition = "TEXT")
   private String middleName;

   @Column(name = "last_name", length = 50, nullable = false, columnDefinition = "TEXT")
   private String lastName;

   @Column(name = "nick_name", length = 100, nullable = false, columnDefinition = "TEXT")
   private String nickName;

   @Column(name = "phone_no", length = 50, nullable = true, unique = true, columnDefinition = "TEXT")
   private String phoneNo;

   @Column(name = "email", length = 50, nullable = false, unique = true, columnDefinition = "TEXT")
   private String email;

   @Column(name = "date_of_birth", nullable = true)
   private LocalDate dateOfBirth;

   @Column(name = "address", length = 250, nullable = true, columnDefinition = "TEXT")
   private String address;

   @Column(name = "occupation", length = 50, nullable = true, columnDefinition = "TEXT")
   private String occupation;

   @Column(name = "gender", length = 1, nullable = true)
   private GenderEnum gender;

   @Column(name = "religion", length = 25, nullable = true)
   private String religion;

   @Column(name = "marriage_status", length = 20, nullable = true)
   private MarriageEnum marriageStatus;

   @Column(name = "marriage_date", nullable = true)
   private LocalDate marriageDate;

   @Column(name = "divorce_date", nullable = true)
   private LocalDate divorceDate;

   @Column(name = "education", length = 20, nullable = true, columnDefinition = "TEXT")
   private String education;

   @Column(name = "is_alive", nullable = false)
   private boolean isAlive = true;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "family_id", nullable = true)
   private Family family;

   @OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "partner_id", nullable = true)
   private Resident partner;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sub_village_id", nullable = true)
   private SubVillage subVillage;

}
