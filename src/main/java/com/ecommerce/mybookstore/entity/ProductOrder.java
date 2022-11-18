package com.ecommerce.mybookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {

    @EmbeddedId
    private OrderProductId id = new OrderProductId();

    @ManyToOne
    @MapsId("orderId")
    private OrderF order;
    @ManyToOne
    @MapsId("productId")
    private Product product;
    private Long quantity;
}
