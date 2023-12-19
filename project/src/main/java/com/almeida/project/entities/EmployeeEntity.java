package com.almeida.project.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer idEmployee;

    @Column(name = "employeecode", nullable = false)
    private Integer employeeCode;

    @Column(name = "nameEmployee", nullable = false)
    private String nameEmployee;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "naturalness")
    private String naturalness;

    @Column(name = "admissionDate")
    private LocalDate admissionDate;

    @Column(name = "pastContract")
    private LocalDate pastContract;

    @Column(name = "workCardNumber")
    private String workCardNumber;

    @Column(name = "pis")
    private String pis;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "rg", nullable = false)
    private String rg;

    @Column(name = "maritalStatus")
    private String maritalStatus;

    @Column(name = "carrerPath")
    private String careerPath;
}