package com.ecommerce.mybookstore.repository;

import com.ecommerce.mybookstore.entity.Adresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressesRepository extends JpaRepository<Adresses,Long> {
    public List<Adresses> findAllByOrderByIdDesc();
}
