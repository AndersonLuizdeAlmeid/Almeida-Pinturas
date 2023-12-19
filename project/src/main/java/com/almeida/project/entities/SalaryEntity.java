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
@Table(name = "salary")
public class SalaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer idSalary;

    @Column(name = "employeeCode", nullable = false)
    private Integer employeeCode;

    @Column(name = "initialSalary", nullable = false)
    private Double initialSalary;

    @Column(name = "currentWage", nullable = false)
    private Double currentWage;

    @Column(name = "salaryUpdateDate")
    private LocalDate salaryUpdateDate;
}
