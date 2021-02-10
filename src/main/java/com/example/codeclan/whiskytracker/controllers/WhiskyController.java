package com.example.codeclan.whiskytracker.controllers;

import com.example.codeclan.whiskytracker.models.Whisky;
import com.example.codeclan.whiskytracker.repositories.WhiskyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        List<Whisky> allWhiskies = whiskyRepository.findAll();
        return new ResponseEntity<>(allWhiskies, HttpStatus.OK);
    }
}