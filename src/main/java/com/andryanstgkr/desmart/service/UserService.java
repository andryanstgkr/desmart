package com.andryanstgkr.desmart.service;

import com.andryanstgkr.desmart.constant.MessageConstant;
import com.andryanstgkr.desmart.model.User;
import com.andryanstgkr.desmart.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, String> {
   Logger logger = LoggerFactory.getLogger(this.getClass());
   @Autowired
   private UserRepository userRepository;

   public UserService(User clazz) {
      super(clazz);
   }

   @Override
   public User update(User t, String activity, String id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String validate(User user) {
      if (this.userRepository.getUserByUserName(user.getUserName()).isPresent()) {
         return MessageConstant.USERNAME_EXIST;
      } 
      else if (this.userRepository.getUserByEmail(user.getEmail()).isPresent()) {
         return MessageConstant.EMAIL_EXIST;
      }
      return MessageConstant.OK;
   }



}
