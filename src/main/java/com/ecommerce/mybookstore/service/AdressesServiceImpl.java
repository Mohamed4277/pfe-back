package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.repository.AdressesRepository;
import com.ecommerce.mybookstore.entity.Adresses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressesServiceImpl implements AdressesService {

    private final AdressesRepository adressesRepository;

    public AdressesServiceImpl(AdressesRepository adressesRepository) {
        this.adressesRepository = adressesRepository;
    }

    @Override
    public List<Adresses> findAllAdresses() {
        return adressesRepository.findAll();
    }

    @Override
    public List<Adresses> findAllByOrderByIdDesc() {
        return adressesRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Optional<Adresses> findById(Long id) {
        return adressesRepository.findById(id);
    }

    @Override
    public Adresses saveAdresses(Adresses category) {
        return adressesRepository.save(category);
    }

    @Override
    public Adresses updateAdresses(Adresses category) {
        return adressesRepository.save(category);
    }

    @Override
    public void deleteAdresses(Long id) {
        adressesRepository.deleteById(id);
    }
}
