package com.almeida.project.dtos;

import lombok.Data;

@Data
public class AdressDTO {
    public String street;
    public Integer number;
    public String neighborhood;
    public String city;
    public String country;
    public String zipCode;
}
