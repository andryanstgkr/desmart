package com.andryanstgkr.desmart.service;

import com.andryanstgkr.desmart.model.SubVillage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SubVillageService extends BaseService<SubVillage, String>{
   Logger logger = LoggerFactory.getLogger(this.getClass());
   public SubVillageService(SubVillage clazz) {
      super(clazz);
   }

   @Override
   public SubVillage update(SubVillage t, String activity, String id) {
      // TODO Auto-generated method stub
      return null;
   }
   
}
