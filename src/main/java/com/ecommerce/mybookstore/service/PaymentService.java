package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.domain.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> findAllPayment();
    Optional<Payment> findById(Long id);
    Payment savePayment(Payment order);
    Payment updatePayment(Payment order);
    void deletePayment(Long id);

}
