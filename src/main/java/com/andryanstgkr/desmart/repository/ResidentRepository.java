package com.andryanstgkr.desmart.repository;

import java.util.Optional;
import com.andryanstgkr.desmart.model.Resident;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends BaseRepository<Resident, String> {
   
   @Query("from Resident r where r.phoneNo=?1")
   public Optional<Resident> getResidentByPhoneNo(String phoneNo);

   @Query("from Resident r where r.email=?1")
   public Optional<Resident> getResidentByEmail(String email);

   @Query("from Resident r where r.icNo=?1")
   public Optional<Resident> getResidentByIcNo(String icNo);
}
