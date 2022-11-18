package com.ecommerce.mybookstore.repository;

import com.ecommerce.mybookstore.entity.PaymentMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentModeRepository extends JpaRepository<PaymentMode,Long> {
}
