package com.almeida.project.dtos;

import java.util.List;

import com.almeida.project.entities.AdressEntity;
import com.almeida.project.entities.BenefitEntity;
import com.almeida.project.entities.EmployeeEntity;
import com.almeida.project.entities.ExamEntity;
import com.almeida.project.entities.SalaryEntity;

import lombok.Data;

@Data
public class RegisteredEmployeeDTO {
    private EmployeeEntity employeeEntity;
    private AdressEntity adressEntity;
    private List<BenefitEntity> benefits;
    private List<ExamEntity> exams;
    private SalaryEntity salaryEntity;
}
