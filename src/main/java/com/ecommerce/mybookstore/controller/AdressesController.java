package com.ecommerce.mybookstore.controller;

import com.ecommerce.mybookstore.entity.Adresses;
import com.ecommerce.mybookstore.service.AdressesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/adress")
public class AdressesController {

    private final AdressesService adressesService;

    public AdressesController(AdressesService adressesService) {
        this.adressesService = adressesService;
    }

    @GetMapping()
    public List<Adresses> findAllAdresses(){
        return adressesService.findAllAdresses();
    }

    @GetMapping("/{id}")
    public Optional<Adresses> findCategoryById(@PathVariable("id") Long id){
        return adressesService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Adresses> saveAdresses(@RequestBody Adresses adresse){
        Adresses adressSaved=adressesService.saveAdresses(adresse);
        return new ResponseEntity<>(adressSaved, HttpStatus.OK);
    }

    @PutMapping
    public Adresses updateAdresses(@RequestBody Adresses adresse){
        return adressesService.saveAdresses(adresse);
    }

    @DeleteMapping("/{id}")
    public void deleteAdresses(@PathVariable("id") Long id){
        adressesService.deleteAdresses(id);
    }

}
