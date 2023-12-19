package com.almeida.project.dtos;

import com.almeida.project.entities.EmployeeEntity;
import com.almeida.project.entities.SalaryEntity;

import lombok.Data;

@Data
public class EmployeeSalaryDTO {
    private EmployeeEntity employeeEntity;
    private SalaryEntity salaryEntity;
}
