package com.example.demo.repo;

import com.example.demo.domain.OrderF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderF,Long> {
    List<OrderF> findByUserId(Long userId);
}
