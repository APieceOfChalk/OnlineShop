package com.shop.onlineShop.service;


import com.shop.onlineShop.entity.Country;
import com.shop.onlineShop.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;

    public void create(Country country){countryRepo.save(country);}

    public void update(Country country){countryRepo.save(country);}

    public void delete(Country country){countryRepo.delete(country);}

    public Optional<Country> find(Long id){return countryRepo.findById(id);}

    public List<Country> findAll(){return countryRepo.findAll();}
}