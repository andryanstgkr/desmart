package com.andryanstgkr.desmart.service;

import com.andryanstgkr.desmart.constant.MessageConstant;
import com.andryanstgkr.desmart.model.Resident;
import com.andryanstgkr.desmart.predicate.MyPredicate;
import com.andryanstgkr.desmart.repository.ResidentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidentService extends BaseService<Resident, String> {
   Logger logger = LoggerFactory.getLogger(this.getClass());
   @Autowired
   private ResidentRepository residentRepository;

   public ResidentService(Resident clazz) {
      super(clazz);
   }

   @Override
   public Resident update(Resident t, String activity, String id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String validate(Resident resident) {
      MyPredicate<Resident> residentPredicate = new MyPredicate<>();

      if (!residentPredicate.isLengthValid(resident.getIcNo(), 16)) {
         return MessageConstant.IC_NO_INVALID_LENGTH;
      }

      if (residentPredicate
            .isValuePresent(this.residentRepository.getResidentByEmail(resident.getEmail()))) {
         return MessageConstant.EMAIL_EXIST;
      } else if (residentPredicate
            .isValuePresent(this.residentRepository.getResidentByPhoneNo(resident.getPhoneNo()))) {
         return MessageConstant.PHONE_NUMBER_EXIST;
      } else if (residentPredicate
            .isValuePresent(this.residentRepository.getResidentByIcNo(resident.getIcNo()))) {
         return MessageConstant.IC_NO_EXIST;
      }
      return MessageConstant.OK;
   }
}
