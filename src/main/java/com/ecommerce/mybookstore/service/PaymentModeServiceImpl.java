package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.repo.PaymentModeRepository;
import com.ecommerce.mybookstore.domain.PaymentMode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentModeServiceImpl implements PaymentModeService {

    private final PaymentModeRepository categoryRepository;

    public PaymentModeServiceImpl(PaymentModeRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<PaymentMode> findAllPaymentMode() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<PaymentMode> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public PaymentMode savePaymentMode(PaymentMode category) {
        return categoryRepository.save(category);
    }

    @Override
    public PaymentMode updatePaymentMode(PaymentMode category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deletPaymentMode(Long id) {
        categoryRepository.deleteById(id);
    }
}
