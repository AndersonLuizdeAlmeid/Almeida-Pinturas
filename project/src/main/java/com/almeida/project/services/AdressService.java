package com.almeida.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almeida.project.dtos.AdressDTO;
import com.almeida.project.entities.AdressEntity;
import com.almeida.project.repositories.AdressRepository;

@Service
public class AdressService {

    @Autowired
    AdressRepository adressRepository;
    @Autowired
    EmployeeService employeeService;

    public AdressEntity addAdress(AdressEntity adressentity) {
        try {
            adressentity.setEmployeeCode(employeeService.getLastEmployeeCode());
            return adressRepository.save(adressentity);
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean removeAdressById(Integer id) {
        try {
            adressRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<AdressEntity> getAllAdresses() {
        List<AdressEntity> adresses = adressRepository.findAll();
        if (adresses == null) {
            return null;
        }
        return adresses;
    }

    public AdressDTO getEmployeeAdress(Integer employeeCode) {
        try {
            var adressEmployee = adressRepository.getValueById(employeeCode);
            AdressDTO adressEmployeeDTO = new AdressDTO();
            adressEmployeeDTO.setCity(adressEmployee.getCity());
            adressEmployeeDTO.setCountry(adressEmployee.getCountry());
            adressEmployeeDTO.setNeighborhood(adressEmployee.getNeighborhood());
            adressEmployeeDTO.setNumber(adressEmployee.getNumber());
            adressEmployeeDTO.setStreet(adressEmployee.getStreet());
            adressEmployeeDTO.setZipCode(adressEmployee.getZipCode());
            return adressEmployeeDTO;
        } catch (Exception e) {
            return null;
        }
    }

}
