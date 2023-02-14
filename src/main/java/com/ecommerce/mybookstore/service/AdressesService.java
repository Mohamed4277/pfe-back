package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.entity.Adresses;

import java.util.List;
import java.util.Optional;

public interface AdressesService {
    List<Adresses> findAllAdresses();
    List<Adresses> findAllByOrderByIdDesc();
    Optional<Adresses> findById(Long id);
    Adresses saveAdresses(Adresses adresses);
    Adresses updateAdresses(Adresses adresses);
    void deleteAdresses(Long id);

}
