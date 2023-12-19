package com.almeida.project.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExamDTO {
    private String typeOfExam;
    private LocalDate dateOfExam;
    private String resultsOfExam;
    private String doctor;
    private Integer employeeCode;
    private String observation;
    private String statusOfExam;
}
