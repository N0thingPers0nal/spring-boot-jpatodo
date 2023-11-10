package com.springtodo.springbootjpatodo.repository;

import com.springtodo.springbootjpatodo.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> {
    @Query("FROM AppUser u WHERE u.userName=:userName AND u.password=:password")
    AppUser findUserByNameAndPassword(@Param("userName") String name,@Param("password") String password);

}
