package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Optional;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    public Cart() {
    }

    public Cart(Medicine medicine, User user, int quantity, Date date) {
        this.medicine = medicine;
        this.user = user;
        this.quantity = quantity;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
