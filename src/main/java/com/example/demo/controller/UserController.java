package com.example.demo.controller;

import com.example.demo.entity.Medicine;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){
        List<User> allUser=service.findAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user){
        User u= service.addUser(user);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUser(@PathVariable ("id") Long id){
        User nuser= service.findUserById(id);
        return new ResponseEntity<>(nuser,HttpStatus.OK);

    }

    @DeleteMapping("/deleteUser/{id}")

    public ResponseEntity<?> deleteUser(@PathVariable ("id") Long id){
         service.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
