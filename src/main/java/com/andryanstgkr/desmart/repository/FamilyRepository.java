package com.andryanstgkr.desmart.repository;

import java.util.Optional;
import com.andryanstgkr.desmart.model.Family;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends BaseRepository<Family, String> {
   
   @Query("from Family f where f.familyIcNo=?1")
   public Optional<Family> getFamilyByIcNo(String icNo);
}
