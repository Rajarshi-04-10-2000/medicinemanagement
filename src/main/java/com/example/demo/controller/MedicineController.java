package com.example.demo.controller;

import com.example.demo.entity.Medicine;
import com.example.demo.repos.MedRepo;
import com.example.demo.service.Medservice;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    Medservice service;
    @GetMapping("/all")
    public  ResponseEntity<List<Medicine>> findAll(){
        List<Medicine> allMed=service.findAllMeds();
        return new ResponseEntity<>(allMed, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Medicine> add(@RequestBody Medicine med){
        Medicine newMed = service.addMedicine(med);
        return new ResponseEntity<>(newMed,HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Medicine> findMed(@PathVariable("id") Long medID){
        Medicine med= service.findById(medID);
        return new ResponseEntity<>(med,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.deleteMed(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
