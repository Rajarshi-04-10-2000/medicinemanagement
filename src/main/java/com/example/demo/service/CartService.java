package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.repos.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepo cart;

}
