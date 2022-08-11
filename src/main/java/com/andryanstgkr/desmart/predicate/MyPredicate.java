package com.andryanstgkr.desmart.predicate;

import java.util.Optional;
import java.util.function.Predicate;

public class MyPredicate<T> {
   
   public boolean isValuePresent(Optional<T> _t){
      Predicate<Optional<T>> valueExistPredicate = t -> t.isPresent();
      return valueExistPredicate.test(_t);
   }

   public boolean isLengthValid(String input, int length){
      Predicate<Integer> lengthPredicate = i -> (i == length);
      return lengthPredicate.test(input.length());
   }
}
