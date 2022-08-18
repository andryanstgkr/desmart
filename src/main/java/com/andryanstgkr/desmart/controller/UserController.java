package com.andryanstgkr.desmart.controller;

import com.andryanstgkr.desmart.base.BaseController;
import com.andryanstgkr.desmart.constant.ActivityConstant;
import com.andryanstgkr.desmart.constant.MessageConstant;
import com.andryanstgkr.desmart.model.User;
import com.andryanstgkr.desmart.service.UserService;
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
@RequestMapping("/users")
public class UserController extends BaseController<User> {
   Logger logger = LoggerFactory.getLogger(this.getClass());

   @Autowired
   private UserService userService;

   @Autowired
   User user;

   public UserController(User clazz) {
      super(clazz);
      user = clazz;
   }

   @Override
   @PostMapping("save")
   public ResponseEntity<Object> save(@RequestBody User user) {
      try {
         logger.debug("Object to save: " + user.toString());
         String errorMessage = "";

         errorMessage = this.userService.validate(user);


         if (!errorMessage.equals(MessageConstant.OK)) {
            return ResponseHandler.generateResponse(errorMessage, ActivityConstant.SAVE, HttpStatus.OK, errorMessage);
         }
         User _user = userService.save(user);

         return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(), ActivityConstant.SAVE, HttpStatus.OK,
               _user);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseHandler.generateResponse(e.getMessage(), ActivityConstant.SAVE, HttpStatus.BAD_REQUEST, null);
      }

   }

}
