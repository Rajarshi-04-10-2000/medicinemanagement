package com.example.demo.controller;

import com.example.demo.entity.Cart;
import com.example.demo.repos.CartRepo;
import com.example.demo.service.CartService;
import com.example.demo.service.Medservice;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private UserService userService;

    @Autowired
    private Medservice medService;

    @Autowired
    private CartService cartService;

    @PostMapping("/add/{userId}/{medId}/{quantity}")
    public ResponseEntity<Cart> addToCart(@PathVariable long userId, @PathVariable long medId, @PathVariable int quantity) {
      Cart newcart= cartService.addToCart(userId,medId,quantity);
      return new ResponseEntity<>(newcart, HttpStatus.OK);
    }

    @GetMapping("/items/{userid}")
    public ResponseEntity<List<Cart>> getCartItemsbyUserid(@PathVariable long userid){
        List<Cart> items = cartService.getCartItems(userid);
        return new ResponseEntity<>(items,HttpStatus.OK);
    }
}
