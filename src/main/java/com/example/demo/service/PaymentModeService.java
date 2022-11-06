package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.domain.PaymentMode;

import java.util.List;
import java.util.Optional;

public interface PaymentModeService {
    List<PaymentMode> findAllPaymentMode();
    Optional<PaymentMode> findById(Long id);
    PaymentMode savePaymentMode(PaymentMode order);
    PaymentMode updatePaymentMode(PaymentMode order);
    void deletPaymentMode(Long id);

}
