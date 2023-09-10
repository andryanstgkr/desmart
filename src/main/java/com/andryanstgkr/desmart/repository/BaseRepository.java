package com.andryanstgkr.desmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//@NoRepositoryBean annotation to indicate it's not supposed to be instantiated at all.
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
    

}