package com.example.customermanagement.CustomerManagement.Controller;

import com.example.customermanagement.CustomerManagement.Models.User;
import com.example.customermanagement.CustomerManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    List<User> getUsers()
    {
        return userRepository.findAll();
    }
    @PostMapping("/user")
    ResponseEntity<User> addUser(@Valid @RequestBody User user)
    {
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }
    @PutMapping("/user/{id}")
    ResponseEntity<User>updateUser(@Valid @RequestBody User user, @PathVariable Long id)
    {
      return userRepository.findById(id).map(
              oldUser ->
              {
               oldUser.setName(oldUser.getName());
               oldUser.setAddress(oldUser.getAddress());
               userRepository.save(oldUser);
               return ResponseEntity.ok().body(oldUser);
              }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/user/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id)
    {
        return userRepository.findById(id).map(
                user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }




}
