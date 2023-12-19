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
@Table(name = "exam")
public class ExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer idExam;

    @Column(name = "employeeCode", nullable = false)
    private Integer employeeCode;

    @Column(name = "typeOfExam", nullable = false)
    private String typeOfExam;

    @Column(name = "dateOfExam", nullable = false)
    private LocalDate dateOfExam;

    @Column(name = "ResultOfExam", nullable = false)
    private String resultsOfExam;

    @Column(name = "doctor")
    private String doctor;

    @Column(name = "observation")
    private String observation;

    @Column(name = "statusOfExam", nullable = false)
    private String statusOfExam;
}
