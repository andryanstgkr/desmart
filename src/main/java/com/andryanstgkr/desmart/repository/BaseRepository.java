package com.andryanstgkr.desmart.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

//@NoRepositoryBean annotation to indicate it's not supposed to be instantiated at all.
@NoRepositoryBean
public interface BaseRepository<T, ID> extends PagingAndSortingRepository<T, ID> {
    

}