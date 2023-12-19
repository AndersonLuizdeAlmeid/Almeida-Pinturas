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

import com.almeida.project.dtos.BenefitDTO;
import com.almeida.project.entities.BenefitEntity;
import com.almeida.project.services.BenefitService;

@RestController
@RequestMapping(value = "/benefit")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BenefitController {

    @Autowired
    private BenefitService benefitService;

    @GetMapping("/findAll")
    public ResponseEntity<List<BenefitEntity>> findAllEmployees() {
        try {
            return ResponseEntity.ok(benefitService.getAllBenefit());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<BenefitEntity> addNewBenefit(@RequestBody BenefitDTO benefit) {
        try {
            return ResponseEntity.ok(benefitService.createNewEmployee(benefit));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    /*
     * @PostMapping("/delete")
     * public ResponseEntity<BenefitEntity> deleteBenefit(@RequestBody BenefitEntity
     * benefit) {
     * benefitService.delete(benefit);
     * return ResponseEntity.ok(benefit);
     * }
     */
}
