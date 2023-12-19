package com.almeida.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.almeida.project.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query(value = "SELECT * FROM user_entity WHERE email=:email", nativeQuery = true)
    public UserEntity getValueById(@Param("email") String email);
}
