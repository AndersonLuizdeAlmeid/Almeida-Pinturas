package com.almeida.project.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeAddDTO {

    private String name;
    private String nationality;
    private String naturalness;
    private LocalDate admissionDate;
    private LocalDate pastContract;
    private String workCardNumber;
    private String pis;
    private String role;
    private String cpf;
    private String rg;
    private String maritalStatus;
    private String careerPath;
}
