package com.ecommerce.mybookstore.repo;

import com.ecommerce.mybookstore.domain.Adresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressesRepository extends JpaRepository<Adresses,Long> {
}
