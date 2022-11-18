package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.repo.PaymentRepository;
import com.ecommerce.mybookstore.domain.Payment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment savePayment(Payment category) {
        return paymentRepository.save(category);
    }

    @Override
    public Payment updatePayment(Payment category) {
        return paymentRepository.save(category);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
