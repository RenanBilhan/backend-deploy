package com.renanb.backend.controller;

import com.renanb.backend.dto.TripInputDto;
import com.renanb.backend.dto.TripOutputDto;
import com.renanb.backend.model.Trip;
import com.renanb.backend.repository.TripRepository;
import com.renanb.backend.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @GetMapping
    public ResponseEntity<List<Trip>> findAll(){
        return ResponseEntity.ok(tripService.findAll());
    }

    @PostMapping
    public ResponseEntity<TripOutputDto> save(@RequestBody TripInputDto inputDto){
        return new ResponseEntity<>(tripService.save(inputDto),HttpStatus.CREATED);
    }

    @GetMapping("{tripId}")
    public ResponseEntity<TripOutputDto> findById(@PathVariable Long tripId){
        return new ResponseEntity<>(tripService.findById(tripId), HttpStatus.OK);
    }
}
