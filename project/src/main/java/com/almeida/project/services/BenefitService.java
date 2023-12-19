package com.almeida.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almeida.project.dtos.BenefitDTO;
import com.almeida.project.entities.BenefitEntity;
import com.almeida.project.repositories.BenefitRepository;

@Service
public class BenefitService {

    @Autowired
    private BenefitRepository benefitRepository;

    @Autowired
    private EmployeeService employeeService;

    public BenefitEntity createNewEmployee(BenefitDTO benefitDTO) {
        try {
            BenefitEntity benefitEntity = new BenefitEntity();
            benefitEntity.setTypeOfBenefit(benefitDTO.getTypeOfBenefit());
            benefitEntity.setNameOfBenefit(benefitDTO.getNameOfBenefit());
            benefitEntity.setBenefitAmount(benefitDTO.getBenefitAmount());
            benefitEntity.setBenefitPaymentDate(benefitDTO.getBenefitPaymentDate());
            benefitEntity.setEmployeeCode(employeeService.getLastEmployeeCode());

            return benefitRepository.save(benefitEntity);
        } catch (Exception e) {
            return null;
        }
    }

    public List<BenefitEntity> getAllBenefit() {
        List<BenefitEntity> employees = null;
        try {
            employees = benefitRepository.getValueById(employeeService.getLastEmployeeCode());
        } catch (Exception e) {
            return null;
        }
        return employees;
    }
}
