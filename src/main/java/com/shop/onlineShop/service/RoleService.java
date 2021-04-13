package com.shop.onlineShop.service;


import com.shop.onlineShop.entity.Role;
import com.shop.onlineShop.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public void create(Role role){roleRepo.save(role);}

    public void update(Role role){roleRepo.save(role);}

    public void delete(Role role){roleRepo.delete(role);}

    public Optional<Role> find(Long id){return roleRepo.findById(id);}

    public List<Role> findAll(){return roleRepo.findAll();}
    
}
