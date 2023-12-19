package com.almeida.project.dtos;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SalaryDTO {
    private Double initialSalary;
    private Double currentWage;
    private LocalDate salaryUpdateDate;
}
