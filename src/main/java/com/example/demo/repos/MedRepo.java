package com.example.demo.repos;

import com.example.demo.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedRepo extends JpaRepository<Medicine,Long> {
    Optional<Medicine> findMedicineBymedID(Long medID);



    void deleteBymedID(Long id);
}
