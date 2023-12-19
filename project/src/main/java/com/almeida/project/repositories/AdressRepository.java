package com.almeida.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.almeida.project.entities.AdressEntity;

@Repository
public interface AdressRepository extends JpaRepository<AdressEntity, Integer> {
    @Query(value = "SELECT * FROM adress_entity WHERE employee_code=:employee_code", nativeQuery = true)
    public AdressEntity getValueById(@Param("employee_code") Integer employee_code);

    @Query(value = "DELETE FROM adress_entity WHERE employee_code=:employee_code", nativeQuery = true)
    public Boolean deleteByEmployeeCode(@Param("employee_code") Integer employee_code);
}
