package com.example.demo.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Entity
@Table(name="medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
    private long medID;
    @Column(name="medicine_name")
    private String medName;
    @Column(name="expiry_date")

    private String expDate;

    public Medicine() {

    }

    public long getMedID() {
        return medID;
    }

    public void setMedID(long medID) {
        this.medID = medID;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Long getQuant() {
        return quant;
    }

    public void setQuant(Long quant) {
        this.quant = quant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name="quantity")

    private Long quant;

    public Medicine(String medName, String expDate, Long quant, double price) {
        this.medName = medName;
        this.expDate = expDate;
        this.quant = quant;
        this.price = price;
    }

    @Column(name="price")

    private double price;


}
