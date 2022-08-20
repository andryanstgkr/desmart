package com.andryanstgkr.desmart.service;

import com.andryanstgkr.desmart.model.Occupation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OccupationService extends BaseService<Occupation, String>{
   Logger logger = LoggerFactory.getLogger(this.getClass());
   public OccupationService(Occupation clazz) {
      super(clazz);
   }

   @Override
   public Occupation update(Occupation t, String activity, String id) {
      // TODO Auto-generated method stub
      return null;
   }
}
