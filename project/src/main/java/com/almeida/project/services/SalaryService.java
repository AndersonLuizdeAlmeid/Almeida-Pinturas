package com.almeida.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almeida.project.dtos.EmployeeSalaryDTO;
import com.almeida.project.dtos.SalaryDTO;
import com.almeida.project.entities.EmployeeEntity;
import com.almeida.project.entities.SalaryEntity;
import com.almeida.project.repositories.EmployeeRepository;
import com.almeida.project.repositories.SalaryRepository;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    public SalaryEntity addSalary(SalaryDTO salaryDTO) {
        SalaryEntity salaryEntity = new SalaryEntity();
        try {
            salaryEntity.setInitialSalary(salaryDTO.getInitialSalary());
            salaryEntity.setSalaryUpdateDate(salaryDTO.getSalaryUpdateDate());
            salaryEntity.setCurrentWage(salaryDTO.getInitialSalary());
            salaryEntity.setEmployeeCode(employeeService.getLastEmployeeCode());
            return salaryRepository.save(salaryEntity);
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean removeSalaryById(Integer employeecode) {
        try {
            return salaryRepository.deleteByEmployeeCode(employeecode);
        } catch (Exception e) {
            return false;
        }
    }

    public List<EmployeeSalaryDTO> getAllEmployeeSalary() {
        List<EmployeeSalaryDTO> employeeSalary = new ArrayList<>();
        List<EmployeeEntity> employees = employeeRepository.findAll();

        try {
            for (EmployeeEntity employeeEntity : employees) {
                EmployeeSalaryDTO employeeSalaryDTO = new EmployeeSalaryDTO();
                employeeSalaryDTO.setEmployeeEntity(employeeEntity);
                SalaryEntity salary = salaryRepository.getValueById(employeeEntity.getEmployeeCode());
                employeeSalaryDTO.setSalaryEntity(salary);

                employeeSalary.add(employeeSalaryDTO);
            }
            return employeeSalary;
        } catch (Exception e) {
            return null;
        }
    }
}
