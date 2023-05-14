package com.example.demo.repos;

import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;


public interface CartRepo extends JpaRepository<Cart, Long> {
    public ArrayList<Cart> findCartByUser(User user);
}
