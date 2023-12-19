package com.almeida.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almeida.project.dtos.ExamDTO;
import com.almeida.project.entities.ExamEntity;
import com.almeida.project.repositories.ExamRepository;

@Service
public class ExamService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ExamRepository examRepository;

    public ExamEntity addExam(ExamDTO examDTO) {
        ExamEntity examEntity = new ExamEntity();
        try {
            examEntity.setEmployeeCode(employeeService.getLastEmployeeCode());
            examEntity.setDateOfExam(examDTO.getDateOfExam());
            examEntity.setDoctor(examDTO.getDoctor());
            examEntity.setObservation(examDTO.getObservation());
            examEntity.setStatusOfExam(examDTO.getStatusOfExam());
            examEntity.setTypeOfExam(examDTO.getTypeOfExam());
            examEntity.setResultsOfExam(examDTO.getResultsOfExam());
            return examRepository.save(examEntity);
        } catch (Exception e) {
            return null;
        }
    }

    public List<ExamEntity> getAllBenefit() {
        try {
            return examRepository.getDataById(employeeService.getLastEmployeeCode());
        } catch (Exception e) {
            return null;
        }
    }

}
