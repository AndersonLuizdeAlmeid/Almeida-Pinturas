package com.almeida.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "adress")
public class AdressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer idAdress;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "employeeCode", nullable = false)
    private Integer employeeCode;
}
