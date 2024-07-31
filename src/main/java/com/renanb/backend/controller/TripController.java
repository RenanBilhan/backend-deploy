package com.renanb.backend.controller;

import com.renanb.backend.model.Trip;
import com.renanb.backend.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trips")
@RequiredArgsConstructor
public class TripController {

    private final TripRepository tripRepository;

    @GetMapping
    public ResponseEntity<List<Trip>> findAll(){
        return ResponseEntity.ok(tripRepository.findAll());
    }
}
