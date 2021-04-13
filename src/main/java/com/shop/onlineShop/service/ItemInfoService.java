package com.shop.onlineShop.service;

import com.shop.onlineShop.entity.ItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.onlineShop.repo.ItemInfoRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ItemInfoService {

    @Autowired
    private ItemInfoRepo itemInfoRepo;

    public void create(ItemInfo itemInfo){itemInfoRepo.save(itemInfo);}

    public void update(ItemInfo itemInfo){itemInfoRepo.save(itemInfo);}

    public void delete(ItemInfo itemInfo){itemInfoRepo.delete(itemInfo);}

    public Optional<ItemInfo> find(Long id){return itemInfoRepo.findById(id);}

    public List<ItemInfo> findAll(){return itemInfoRepo.findAll();}
    
}
