package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.entity.OrderF;
import com.ecommerce.mybookstore.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderF> findAllOrder() {
        return orderRepository.findAll();
    }



    @Override
    public Optional<OrderF> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public OrderF saveOrder(OrderF product) {
        return orderRepository.save(product);
    }

    @Override
    public OrderF updateOrder(OrderF product) {
        return orderRepository.save(product);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderF> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
