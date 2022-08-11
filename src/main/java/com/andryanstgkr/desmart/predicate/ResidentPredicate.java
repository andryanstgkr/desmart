package com.andryanstgkr.desmart.predicate;

import java.util.Optional;
import java.util.function.Predicate;
import com.andryanstgkr.desmart.model.Resident;

public class ResidentPredicate {
   public static boolean isIcNoLengthValid(String icNo){
      Predicate<Integer> icNoLengthPredicate = i -> (i == 16);
      return icNoLengthPredicate.test(icNo.length());
   }

   public static boolean isValuePresent(Optional<Resident> resident){
      Predicate<Optional<Resident>> valueExistPredicate = optResident -> optResident.isPresent();
      return valueExistPredicate.test(resident);
   }
}
