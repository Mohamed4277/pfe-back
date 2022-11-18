package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.domain.OrderF;
import com.ecommerce.mybookstore.domain.ProductOrder;

import java.util.List;
import java.util.Optional;

public interface ProductOrderService {
    List<ProductOrder> findAllProductOrder();
    Optional<ProductOrder> findById(Long id);
    ProductOrder saveProductOrder(ProductOrder order);
    ProductOrder updateProductOrder(ProductOrder order);
    void deleteProductOrder(Long id);
    Optional<ProductOrder> findByProductOrderId(Long userId);

    List<ProductOrder> findByOrder(OrderF order);


}
