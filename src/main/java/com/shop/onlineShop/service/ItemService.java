package com.shop.onlineShop.service;


import com.shop.onlineShop.entity.Item;
import com.shop.onlineShop.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    public void create(Item item){itemRepo.save(item);}

    public void update(Item item){itemRepo.save(item);}

    public void delete(Item item){itemRepo.delete(item);}

    public Optional<Item> find(Long id){return itemRepo.findById(id);}

    public List<Item> findAll(){return itemRepo.findAll();}
    
}
