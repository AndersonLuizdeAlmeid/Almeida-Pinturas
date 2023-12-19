package com.almeida.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.almeida.project.entities.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Query(value = "SELECT * FROM employee_entity WHERE employee_code=:employee_code", nativeQuery = true)
    public EmployeeEntity getDataById(@Param("employee_code") Integer employee_code);

    @Query(value = "SELECT * FROM employee_entity WHERE name=:name", nativeQuery = true)
    public EmployeeEntity getDataByName(@Param("name") String name);

    @Query(value = "SELECT max(employee_code) FROM employee_entity", nativeQuery = true)
    public Integer getLastIdEmployee();

    @Query(value = "DELETE FROM employee_entity WHERE employee_code = employee_code", nativeQuery = true)
    public Boolean deleteByEmployeeCode(@Param("employee_code") Integer employee_code);
}
