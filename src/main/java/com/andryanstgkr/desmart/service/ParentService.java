package com.andryanstgkr.desmart.service;

import com.andryanstgkr.desmart.model.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ParentService extends BaseService<Parent, String> {
   Logger logger = LoggerFactory.getLogger(this.getClass());
   public ParentService(Parent clazz) {
      super(clazz);
   }

   @Override
   public Parent update(Parent t, String activity, String id) {
      // TODO Auto-generated method stub
      return null;
   }
   
}
