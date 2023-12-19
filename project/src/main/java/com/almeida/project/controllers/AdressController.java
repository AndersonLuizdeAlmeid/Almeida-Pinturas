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

import com.almeida.project.dtos.AdressDTO;
import com.almeida.project.entities.AdressEntity;
import com.almeida.project.services.AdressService;

@RestController
@RequestMapping(value = "/adress")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdressController {

    @Autowired
    AdressService adressService;

    @PostMapping("/add")
    public ResponseEntity<AdressEntity> newAdressEmployee(@RequestBody AdressEntity adress) {

        try {
            return ResponseEntity.ok(adressService.addAdress(adress));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestBody AdressEntity adress) {
        try {
            if (adressService.removeAdressById(adress.getIdAdress())) {
                return ResponseEntity.ok(adress.getIdAdress() + " foi deletado do banco de dados");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível excluir o endereço." + e.getMessage());
        }
        return ResponseEntity.ok("Não foi possível excluir o endereço.");
    }

    @PostMapping("/get")
    public ResponseEntity<AdressDTO> getEmployeeAdress(@RequestParam Integer employeeCode) {
        try {
            return ResponseEntity.ok(adressService.getEmployeeAdress(employeeCode));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AdressEntity>> findAllAdress() {
        try {
            return ResponseEntity.ok(adressService.getAllAdresses());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
