package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductId implements Serializable {

    private static final long serialVersionUID = 454929274153812112L;
    private Long orderId;
    private Long productId;
}
