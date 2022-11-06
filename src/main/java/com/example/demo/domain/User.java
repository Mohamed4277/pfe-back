package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public User(Long id, String name, String username, String password, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }


    public User(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

    public User(Long id, String name, String username, String password,
                String lastName, String adressPartOne, String adressPartTwo,
                String zip, String city) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.adressPartOne = adressPartOne;
        this.adressPartTwo = adressPartTwo;
        this.zip = zip;
        this.city = city;
    }




    private String username;
    @JsonIgnore
    private String password;
    private String lastName ;
    private String adressPartOne;
    private String adressPartTwo;
    private String zip;
    private String city;

    @ManyToMany
    private Collection<Role> roles = new ArrayList<>();

    @OneToOne
    private WishList whishList;

    @OneToMany
    private List<PaymentMode> paymentMode=null;

    @OneToMany
    private List<Adresses> adresses;


}
