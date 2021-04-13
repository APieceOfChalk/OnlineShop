package com.shop.onlineShop.controller;

import com.shop.onlineShop.entity.Users;
import com.shop.onlineShop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody Users users){
        usersService.create(users);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> findALL(){
        final List<Users> usersList = usersService.findAll();
        return usersList != null && !usersList.isEmpty()
                ? new ResponseEntity<>(usersList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<Users>> find(@PathVariable(name = "id")Long id){
        final Optional<Users> users = usersService.find(id);
        return users!=null
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUsers(@PathVariable(name = "id")Long id, @RequestBody Users usersUpdate){
        return usersService.find(id).map(users -> {
            users.setRole(usersUpdate.getRole());
            users.setEmail(usersUpdate.getEmail());
            users.setUserProfile(usersUpdate.getUserProfile());
            users.setHashedPassword(usersUpdate.getHashedPassword());
            users.setIsActive(usersUpdate.getIsActive());
            usersService.update(users);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }


}
