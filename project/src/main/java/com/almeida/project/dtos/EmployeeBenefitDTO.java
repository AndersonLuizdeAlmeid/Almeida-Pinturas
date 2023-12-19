package com.almeida.project.dtos;

import java.util.List;

import com.almeida.project.entities.BenefitEntity;
import com.almeida.project.entities.EmployeeEntity;

import lombok.Data;

@Data
public class EmployeeBenefitDTO {
    private EmployeeEntity employeeEntity;
    private List<BenefitEntity> listBenefit;
}
