package com.andryanstgkr.desmart.service;

import com.andryanstgkr.desmart.constant.MessageConstant;
import com.andryanstgkr.desmart.model.Family;
import com.andryanstgkr.desmart.model.Resident;
import com.andryanstgkr.desmart.predicate.MyPredicate;
import com.andryanstgkr.desmart.repository.FamilyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyService extends BaseService<Family, String> {
   Logger logger = LoggerFactory.getLogger(this.getClass());
   @Autowired
   private FamilyRepository familyRepository;

   private Family family;
   public FamilyService(Family clazz) {
      super(clazz);
      this.family = clazz;
   }

   @Override
   public Family update(Family family, String activity, String id) {
      // TODO Auto-generated method stub
      return null;
   }

   public Family addChildren(Family family, List<Resident> children) {
      MyPredicate<Family> predicate = new MyPredicate<>();
      Optional<Family> optFamily = this.familyRepository.getFamilyByIcNo(family.getFamilyIcNo());

      if (predicate.isValuePresent(optFamily)) {
         Family newFamily = optFamily.get();
         newFamily.getChildren().addAll(children);
         return newFamily;
      }

      return null;

   }

   @Override
   public String validate(Family family) {
      MyPredicate<Family> familyPredicate = new MyPredicate<>();

      if (!familyPredicate.isLengthValid(family.getFamilyIcNo(), 16)) {
         return MessageConstant.IC_NO_INVALID_LENGTH;
      }

      if (familyPredicate
            .isValuePresent(this.familyRepository.getFamilyByIcNo(family.getFamilyIcNo()))) {
         return MessageConstant.IC_NO_EXIST;
      }
      return MessageConstant.OK;
   }



}
