package com.example.demo.entity;

import jakarta.persistence.*;

@Entity

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;
    private long quantity;
    private String date;
    @OneToOne
    private Medicine med;

    @OneToOne
    private User user;

}
