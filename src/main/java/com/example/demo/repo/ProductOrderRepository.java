package com.example.demo.repo;

import com.example.demo.domain.OrderF;
import com.example.demo.domain.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder,Long> {
   List<ProductOrder> findByOrder(OrderF order);
}
