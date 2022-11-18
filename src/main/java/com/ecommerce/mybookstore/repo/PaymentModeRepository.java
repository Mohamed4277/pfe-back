package com.ecommerce.mybookstore.repo;

import com.ecommerce.mybookstore.domain.PaymentMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentModeRepository extends JpaRepository<PaymentMode,Long> {
}
