package com.example.demo.service;

import com.example.demo.domain.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> findAllPayment();
    Optional<Payment> findById(Long id);
    Payment savePayment(Payment order);
    Payment updatePayment(Payment order);
    void deletePayment(Long id);

}
