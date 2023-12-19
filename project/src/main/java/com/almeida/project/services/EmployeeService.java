package com.almeida.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almeida.project.dtos.EmployeeAddDTO;
import com.almeida.project.dtos.EmployeeBenefitDTO;
import com.almeida.project.dtos.RegisteredEmployeeDTO;
import com.almeida.project.entities.BenefitEntity;
import com.almeida.project.entities.EmployeeEntity;
import com.almeida.project.entities.ExamEntity;
import com.almeida.project.repositories.AdressRepository;
import com.almeida.project.repositories.BenefitRepository;
import com.almeida.project.repositories.EmployeeRepository;
import com.almeida.project.repositories.ExamRepository;
import com.almeida.project.repositories.SalaryRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BenefitRepository benefitRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    public EmployeeEntity createNewEmployee(EmployeeAddDTO employeeAddDTO) {
        try {
            EmployeeEntity employee = new EmployeeEntity();
            employee.setEmployeeCode(getNewEmployeeCode());
            employee.setAdmissionDate(employeeAddDTO.getAdmissionDate());
            employee.setCareerPath(employeeAddDTO.getCareerPath());
            employee.setCpf(employeeAddDTO.getCpf());
            employee.setMaritalStatus(employeeAddDTO.getMaritalStatus());
            employee.setNameEmployee(employeeAddDTO.getName());
            employee.setNationality(employeeAddDTO.getNationality());
            employee.setNaturalness(employeeAddDTO.getNaturalness());
            employee.setPastContract(employeeAddDTO.getPastContract());
            employee.setPis(employeeAddDTO.getPis());
            employee.setRg(employeeAddDTO.getRg());
            employee.setRole(employeeAddDTO.getRole());
            employee.setWorkCardNumber(employeeAddDTO.getWorkCardNumber());
            return employeeRepository.save(employee);
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean deleteEmployee(Integer employeeCode) {
        try {
            var employee = employeeRepository.getDataById(employeeCode);
            employeeRepository.deleteById(employee.getIdEmployee());
            var adress = adressRepository.getValueById(employeeCode);
            adressRepository.deleteById(adress.getIdAdress());
            var salary = salaryRepository.getValueById(employeeCode);
            salaryRepository.deleteById(salary.getIdSalary());
            var benefits = benefitRepository.getValueById(employeeCode);
            for (BenefitEntity benefits2 : benefits) {
                benefitRepository.deleteById(benefits2.getIdBenefit());
            }
            var exams = examRepository.getDataById(employeeCode);
            for (ExamEntity exams2 : exams) {
                examRepository.deleteById(exams2.getIdExam());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<EmployeeEntity> getAllEmployee() {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public EmployeeBenefitDTO findEmployeeAndBenefitById(Integer idEmployee) {
        EmployeeBenefitDTO employee = new EmployeeBenefitDTO();
        try {
            employee.setEmployeeEntity(employeeRepository.getDataById(idEmployee));
            employee.setListBenefit(benefitRepository.getValueById(idEmployee));
        } catch (Exception e) {
            return null;
        }
        return employee;
    }

    public Integer getNewEmployeeCode() {
        try {
            return employeeRepository.getLastIdEmployee() + 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public Integer getLastEmployeeCode() {
        try {
            return employeeRepository.getLastIdEmployee();
        } catch (Exception e) {
            return 0;
        }
    }

    public EmployeeEntity getEmployeeByName(String name) {
        try {
            return employeeRepository.getDataByName(name);
        } catch (Exception e) {
            return null;
        }
    }

    public RegisteredEmployeeDTO getRegisteredEmployee() {
        RegisteredEmployeeDTO registeredEmployeeDTO = new RegisteredEmployeeDTO();
        var employeeCode = getLastEmployeeCode();
        try {
            registeredEmployeeDTO.setEmployeeEntity(employeeRepository.getDataById(employeeCode));
            registeredEmployeeDTO.setAdressEntity(adressRepository.getValueById(employeeCode));
            registeredEmployeeDTO.setSalaryEntity(salaryRepository.getValueById(employeeCode));
            registeredEmployeeDTO.setBenefits(benefitRepository.getValueById(employeeCode));
            registeredEmployeeDTO.setExams(examRepository.getDataById(employeeCode));

            return registeredEmployeeDTO;
        } catch (Exception e) {
            return null;
        }
    }
}
