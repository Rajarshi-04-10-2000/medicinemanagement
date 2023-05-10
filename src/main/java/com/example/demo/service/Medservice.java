package com.example.demo.service;

import com.example.demo.entity.Medicine;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repos.MedRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class Medservice {
    @Autowired
    private MedRepo repo;

    public Medicine addMedicine(Medicine medicine){
        return repo.save(medicine);

    }

    public List<Medicine> findAllMeds(){
        return repo.findAll();
    }

    public Medicine findById(Long id){
        return repo.findMedicineBymedID(id).orElseThrow(()-> new ResourceNotFoundException("Not found"));
    }

    public void deleteMed(Long id){
        repo.deleteBymedID(id);
    }
}
