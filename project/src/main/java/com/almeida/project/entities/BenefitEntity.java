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
@Table(name = "benefit")
public class BenefitEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idBenefit;

    @Column(name = "typeOfBenefit")
    private String typeOfBenefit;

    @Column(name = "nameOfBenefit")
    private String nameOfBenefit;

    @Column(name = "employeeCode")
    private Integer employeeCode;

    @Column(name = "benefitAmount")
    private Double benefitAmount;

    @Column(name = "benefitPaymentDate")
    private LocalDate benefitPaymentDate;
}
