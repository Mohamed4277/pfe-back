package com.example.demo.service;

import com.example.demo.domain.OrderF;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderF> findAllOrder();
    Optional<OrderF> findById(Long id);
    OrderF saveOrder(OrderF order);
    OrderF updateOrder(OrderF order);
    void deleteOrder(Long id);

    List<OrderF> findByUserId(Long userId);

}
