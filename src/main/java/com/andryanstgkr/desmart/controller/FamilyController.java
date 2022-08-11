package com.andryanstgkr.desmart.controller;

import com.andryanstgkr.desmart.base.BaseController;
import com.andryanstgkr.desmart.constant.ActivityConstant;
import com.andryanstgkr.desmart.model.Family;
import com.andryanstgkr.desmart.service.FamilyService;
import com.andryanstgkr.desmart.utilities.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/family")
public class FamilyController extends BaseController<Family> {

   Logger logger = LoggerFactory.getLogger(this.getClass());

   @Autowired
   private FamilyService familyService;

   @PostMapping("add-children")
   public ResponseEntity<Object> addChildren(@RequestBody Family family) {
      try {
         logger.info("family.getId(): " + family.getId());
         Family f = this.familyService.getDetail(family.getId()).get();
         logger.info("f.getId(): " + f.getChildren().get(0).getFirstName());
         logger.info("f.getId(): " + f.getChildren().get(1).getFirstName());
         String errorMessage = "";

         // errorMessage = this.familyService.validate(family);

         // if (!errorMessage.equals(MessageConstant.OK)) {
         // return ResponseHandler.generateResponse(errorMessage, ActivityConstant.SAVE,
         // HttpStatus.OK, errorMessage);
         // }
         //Family _family = familyService.addChildren(f, family.getChildren());
         f.getChildren().addAll(family.getChildren());
         logger.info("_family.getId(): " + f.getChildren().get(2).getFirstName());
         logger.info("_family.getId(): " + f.getChildren().get(3).getFirstName());

         logger.info("_family.getName(): " + f.getName());
         // _family = this.familyService.save(optFamily.get());


         return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(),
               ActivityConstant.SAVE, HttpStatus.OK, f);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseHandler.generateResponse(e.getMessage(), ActivityConstant.SAVE,
               HttpStatus.BAD_REQUEST, null);
      }

   }
}
