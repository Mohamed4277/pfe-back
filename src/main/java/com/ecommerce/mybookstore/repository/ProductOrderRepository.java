package com.ecommerce.mybookstore.repo;

import com.ecommerce.mybookstore.domain.OrderF;
import com.ecommerce.mybookstore.domain.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder,Long> {
   List<ProductOrder> findByOrder(OrderF order);
}
