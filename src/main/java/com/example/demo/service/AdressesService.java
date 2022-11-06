package com.example.demo.service;

import com.example.demo.domain.Adresses;

import java.util.List;
import java.util.Optional;

public interface AdressesService {
    List<Adresses> findAllAdresses();
    Optional<Adresses> findById(Long id);
    Adresses saveAdresses(Adresses adresses);
    Adresses updateAdresses(Adresses adresses);
    void deleteAdresses(Long id);

}
