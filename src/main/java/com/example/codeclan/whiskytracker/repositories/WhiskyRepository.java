package com.example.codeclan.whiskytracker.repositories;

import com.example.codeclan.whiskytracker.models.Distillery;
import com.example.codeclan.whiskytracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByYear(int year);
    List<Whisky> findByAgeAndDistilleryId(int age, Long distilleryId);
}
