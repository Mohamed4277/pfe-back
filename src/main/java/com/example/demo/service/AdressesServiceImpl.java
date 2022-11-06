package com.example.demo.service;

import com.example.demo.domain.Adresses;
import com.example.demo.repo.AdressesRepository;
import lombok.extern.slf4j.Slf4j;
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
