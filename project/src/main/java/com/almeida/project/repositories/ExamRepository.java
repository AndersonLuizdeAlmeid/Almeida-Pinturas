package com.almeida.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.almeida.project.entities.ExamEntity;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Integer> {
    @Query(value = "SELECT * FROM exam_entity WHERE employee_code=:employee_code", nativeQuery = true)
    public List<ExamEntity> getDataById(@Param("employee_code") Integer employee_code);

    @Query(value = "DELETE FROM exam_entity WHERE employee_code=:employee_code", nativeQuery = true)
    public Boolean deleteByEmployeeCode(@Param("employee_code") Integer employee_code);
}
