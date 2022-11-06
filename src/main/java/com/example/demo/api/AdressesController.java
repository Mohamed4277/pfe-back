package com.example.demo.api;

import com.example.demo.domain.Adresses;
import com.example.demo.service.AdressesService;
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
    public Adresses saveAdresses(@RequestBody Adresses adresse){
        return adressesService.saveAdresses(adresse);
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
