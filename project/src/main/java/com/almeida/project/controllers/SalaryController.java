package com.almeida.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almeida.project.dtos.EmployeeSalaryDTO;
import com.almeida.project.dtos.SalaryDTO;
import com.almeida.project.entities.SalaryEntity;
import com.almeida.project.services.SalaryService;

@RestController
@RequestMapping("/salary")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/add")
    public ResponseEntity<SalaryEntity> newEmployeeSalary(@RequestBody SalaryDTO salaryDTO) {
        try {
            return ResponseEntity.ok(salaryService.addSalary(salaryDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteSalary(@RequestParam Integer employeeCode) {
        try {
            if (salaryService.removeSalaryById(employeeCode)) {
                return ResponseEntity.ok("Salario excluido para o funcionário " + employeeCode);
            }
            return ResponseEntity.ok("Problema ao excluir o funcionário " + employeeCode);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Problema ao excluir o funcionário " + employeeCode);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeSalaryDTO>> getAllEmployeesSalary() {
        try {
            return ResponseEntity.ok(salaryService.getAllEmployeeSalary());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
