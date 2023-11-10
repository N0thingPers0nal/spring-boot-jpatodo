package com.springtodo.springbootjpatodo.repository;

import com.springtodo.springbootjpatodo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
