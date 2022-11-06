package com.example.demo.repo;

import com.example.demo.domain.Adresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressesRepository extends JpaRepository<Adresses,Long> {
}
