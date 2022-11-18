package com.ecommerce.mybookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

    public WishList(String name, List<Product> product) {
        this.name = name;
        this.product = product;
    }

    @OneToMany
    private List<Product>  product;

}
