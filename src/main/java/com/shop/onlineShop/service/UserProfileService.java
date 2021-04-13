package com.shop.onlineShop.service;

import com.shop.onlineShop.entity.UserProfile;
import com.shop.onlineShop.repo.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepo userProfileRepo;

    public void create(UserProfile userProfile){userProfileRepo.save(userProfile);}

    public void update(UserProfile userProfile){userProfileRepo.save(userProfile);}

    public void delete(UserProfile userProfile){userProfileRepo.delete(userProfile);}

    public Optional<UserProfile> find(Long id){return userProfileRepo.findById(id);}

    public List<UserProfile> findAll(){return userProfileRepo.findAll();}
}
