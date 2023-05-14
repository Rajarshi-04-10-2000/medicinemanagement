package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Medicine;
import com.example.demo.entity.User;
import com.example.demo.repos.CartRepo;
import com.example.demo.repos.MedRepo;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    MedRepo medRepo;

    public Cart addToCart(long userId, long medId, int quantity){
        User user = userRepo.findById(userId).get();
        Medicine med = medRepo.findById(medId).get();
        if (user == null || med == null) {
            return null;
        }
        Cart cartItem = new Cart(med,user,quantity, new Date());

        cartRepo.save(cartItem);
        return cartItem;
    }
    public List<Cart> getCartItems(long userId){
        User user = userRepo.findById(userId).get();
        if (user == null) {
            return null;
        }
       List<Cart> items =  cartRepo.findAll();
        items= items.stream()
                .filter(cart -> cart.getUser().getUserID() == userId)
                .collect(Collectors.toList());
        return items;
    }

}
