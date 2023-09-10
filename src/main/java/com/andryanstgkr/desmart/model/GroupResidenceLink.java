package com.andryanstgkr.desmart.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Component
public class GroupResidenceLink extends BaseEntity{
   @OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "group_id")
   private Group group;

   @OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "resident_id")
   private Resident resident;

}
