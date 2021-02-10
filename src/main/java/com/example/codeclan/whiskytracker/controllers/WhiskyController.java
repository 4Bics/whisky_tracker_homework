package com.example.codeclan.whiskytracker.controllers;

import com.example.codeclan.whiskytracker.models.Distillery;
import com.example.codeclan.whiskytracker.models.Whisky;
import com.example.codeclan.whiskytracker.repositories.WhiskyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "distillery", required = false) Long distilleryId
    ){
        if (year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }

        if (age != null && distilleryId != null){
            return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryId(age, distilleryId), HttpStatus.OK);
        }

        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
}
