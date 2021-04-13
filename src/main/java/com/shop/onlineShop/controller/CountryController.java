package com.shop.onlineShop.controller;

import com.shop.onlineShop.entity.Country;
import com.shop.onlineShop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }
    @PostMapping("/country")
    public ResponseEntity<?> create(@RequestBody Country country){
        countryService.create(country);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/country")
    public ResponseEntity<List<Country>> findALL(){
        final List<Country> countryList = countryService.findAll();
        return countryList != null && !countryList.isEmpty()
                ? new ResponseEntity<>(countryList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<Optional<Country>> find(@PathVariable(name = "id")Long id){
        final Optional<Country> country = countryService.find(id);
        return country!=null
                ? new ResponseEntity<>(country, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/country/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable(name = "id")Long id, @RequestBody Country countryUpdate){
        return countryService.find(id).map(country -> {
            country.setCountryName(countryUpdate.getCountryName());
            countryService.update(country);
            return new ResponseEntity<>(country, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

}
