package com.andryanstgkr.desmart.controller;

import com.andryanstgkr.desmart.base.BaseController;
import com.andryanstgkr.desmart.constant.ActivityConstant;
import com.andryanstgkr.desmart.constant.MessageConstant;
import com.andryanstgkr.desmart.model.Resident;
import com.andryanstgkr.desmart.service.ResidentService;
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
@RequestMapping("/resident")
public class ResidentController extends BaseController<Resident>{

   Logger logger = LoggerFactory.getLogger(this.getClass());
   @Autowired
   private ResidentService residentService;

   @Override
   @PostMapping("save")
   public ResponseEntity<Object> save(@RequestBody Resident resident) {
      try {
         logger.debug("Object to save: " + resident.toString());
         String errorMessage = "";

         errorMessage = this.residentService.validate(resident);


         if (!errorMessage.equals(MessageConstant.OK)) {
            return ResponseHandler.generateResponse(errorMessage, ActivityConstant.SAVE, HttpStatus.OK, errorMessage);
         }
         Resident _resident = residentService.save(resident);

         return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(), ActivityConstant.SAVE, HttpStatus.OK,
         _resident);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseHandler.generateResponse(e.getMessage(), ActivityConstant.SAVE, HttpStatus.BAD_REQUEST, null);
      }

   }
}
