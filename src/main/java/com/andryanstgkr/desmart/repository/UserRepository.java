package com.andryanstgkr.desmart.repository;

import java.util.Optional;
import com.andryanstgkr.desmart.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, String> {
   @Query("from User u where u.userName=?1")
   public Optional<User> getUserByUserName(String userName);

   @Query("from User u where u.email=?1")
   public Optional<User> getUserByEmail(String email);
}
