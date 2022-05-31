package com.example.day19.repository;

import com.example.day19.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u " +
            "join fetch u.userRoleSet urs " +
            "join fetch urs.role_l " +
            "where u.username =:username")
    User findUserByUserName(@Param("username") String username);


    @Query("select distinct u from User u " +
            "left join fetch u.userRoleSet urs " +
            "join fetch urs.role_l " +
            "where u.userId =:userId")
    User findUserByUserId(@Param("userId") String userId);


    @Query("select distinct u from User u " +
            "left join fetch u.userRoleSet urs " +
            "join fetch urs.role_l ")
    List<User> findAllUser();


}
