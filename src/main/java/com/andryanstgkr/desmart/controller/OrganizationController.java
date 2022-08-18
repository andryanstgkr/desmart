package com.andryanstgkr.desmart.controller;

import com.andryanstgkr.desmart.base.BaseController;
import com.andryanstgkr.desmart.model.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
public class OrganizationController extends BaseController<Organization>{
   Logger logger = LoggerFactory.getLogger(this.getClass());

   @Autowired
   Organization organization ;

   public OrganizationController(Organization clazz) {
      super(clazz);
      organization = clazz;
   }
}
