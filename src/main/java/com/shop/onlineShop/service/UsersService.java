package com.shop.onlineShop.service;

import com.shop.onlineShop.entity.Users;
import com.shop.onlineShop.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepo usersRepo;

    public void create(Users users){usersRepo.save(users);}

    public void update(Users users){usersRepo.save(users);}

    public void delete(Users users){usersRepo.delete(users);}

    public Optional<Users> find(Long id){return usersRepo.findById(id);}

    public List<Users> findAll(){return usersRepo.findAll();}
}
