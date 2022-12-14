package com.ecommerce.mybookstore.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Category(Long id, String category) {
        this.id = id;
        this.category = category;
    }
    public Long getId() {
        return id;
    }

    private String category;

    public Category(String category) {
    }

    @OneToMany
    private List<Product> products;

}
