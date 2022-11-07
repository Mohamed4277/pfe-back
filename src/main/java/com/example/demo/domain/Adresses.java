package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adresses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameAdress;
    private String lastNameAdress;
    private String streetNumber;
    private String adressPartOne;
    private String adressPartTwo;
    private String zip;
    private String city;
    private  Boolean isInvoiceAdress;

}
