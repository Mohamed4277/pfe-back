package com.ecommerce.mybookstore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private  Boolean isDeliveryAdress;

}
