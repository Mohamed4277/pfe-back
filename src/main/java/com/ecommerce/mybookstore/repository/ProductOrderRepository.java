package com.ecommerce.mybookstore.repository;

import com.ecommerce.mybookstore.entity.OrderF;
import com.ecommerce.mybookstore.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder,Long> {
   List<ProductOrder> findByOrder(OrderF order);
}
