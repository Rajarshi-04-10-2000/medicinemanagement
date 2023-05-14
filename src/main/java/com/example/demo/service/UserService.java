package com.example.demo.service;

import com.example.demo.entity.Medicine;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repos.CartRepo;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    CartRepo cartRepo;
    public User addUser(User user){
        return userRepo.save(user);

    }

    public List<User> findAllUser(){
        return userRepo.findAll();
    }

    public User findUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    public void deleteUserById(Long id) {
        User userToDelete = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        userRepo.delete(userToDelete);
    }


}
