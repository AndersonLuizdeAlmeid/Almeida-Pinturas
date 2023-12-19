package com.almeida.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almeida.project.dtos.ExamDTO;
import com.almeida.project.entities.ExamEntity;
import com.almeida.project.services.ExamService;

@RestController
@RequestMapping("/exam")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/add")
    public ResponseEntity<ExamEntity> newExam(@RequestBody ExamDTO exam) {
        try {
            return ResponseEntity.ok(examService.addExam(exam));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ExamEntity>> findAllExamsOfEmployee() {
        try {
            return ResponseEntity.ok(examService.getAllBenefit());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
