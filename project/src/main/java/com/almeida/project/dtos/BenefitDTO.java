package com.almeida.project.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BenefitDTO {
    private String typeOfBenefit;
    private String nameOfBenefit;
    private Double benefitAmount;
    private LocalDate benefitPaymentDate;
}
