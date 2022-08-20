package com.andryanstgkr.desmart.service;

import com.andryanstgkr.desmart.model.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService extends BaseService<Organization, String>{
   Logger logger = LoggerFactory.getLogger(this.getClass());
   public OrganizationService(Organization clazz) {
      super(clazz);
   }

   @Override
   public Organization update(Organization t, String activity, String id) {
      // TODO Auto-generated method stub
      return null;
   }
   
}
