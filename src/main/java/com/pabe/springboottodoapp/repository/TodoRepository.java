package com.pabe.springboottodoapp.repository;

import com.pabe.springboottodoapp.domain.Todo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo, Long>{

}