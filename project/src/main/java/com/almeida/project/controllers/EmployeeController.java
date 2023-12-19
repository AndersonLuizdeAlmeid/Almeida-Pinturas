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

import com.almeida.project.dtos.EmployeeAddDTO;
import com.almeida.project.dtos.EmployeeBenefitDTO;
import com.almeida.project.dtos.RegisteredEmployeeDTO;
import com.almeida.project.entities.EmployeeEntity;
import com.almeida.project.services.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeEntity>> findAllEmployees() {
        try {
            return ResponseEntity.ok(employeeService.getAllEmployee());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/findEmployeeBenefit")
    public ResponseEntity<EmployeeBenefitDTO> findEmployeeAndBenefitById(@RequestParam Integer idEmployee) {
        try {
            EmployeeBenefitDTO employeeAndBenefits = employeeService.findEmployeeAndBenefitById(idEmployee);
            return ResponseEntity.ok(employeeAndBenefits);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeEntity> newEmployee(@RequestBody EmployeeAddDTO employee) {

        try {
            var employeeData = employeeService.createNewEmployee(employee);
            if (employeeData == null) {
                return ResponseEntity.ok(null);
            }
            return ResponseEntity.ok(employeeData);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestParam Integer employeeCode) {
        try {
            if (employeeService.deleteEmployee(employeeCode)) {
                return ResponseEntity.ok("Funcionário foi deletado do banco de dados");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok("Não foi possível excluir o funcionário.");
    }

    @GetMapping("/findEmployee")
    public ResponseEntity<EmployeeEntity> newIdEmployee(@RequestParam("name") String name) {
        try {
            return ResponseEntity.ok(employeeService.getEmployeeByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/getRegisteredEmployee")
    public ResponseEntity<RegisteredEmployeeDTO> getRegisteredEmployee() {
        try {
            return ResponseEntity.ok(employeeService.getRegisteredEmployee());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
