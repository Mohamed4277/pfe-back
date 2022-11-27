package com.ecommerce.mybookstore.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "uuid")
    @Type(type = "uuid-char")
    private UUID uuid = UUID.randomUUID();
    private String name;
    private String description;
    private String autor;
    private String edition;
    private Date date;
    private Double price;
    private String image;

    @ManyToOne
    @JsonIgnore
    private Category category;

}
