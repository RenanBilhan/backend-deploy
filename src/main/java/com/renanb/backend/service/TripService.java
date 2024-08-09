package com.renanb.backend.service;

import com.renanb.backend.dto.TripInputDto;
import com.renanb.backend.dto.TripOutputDto;
import com.renanb.backend.model.Trip;
import com.renanb.backend.repository.TripRepository;
import com.renanb.backend.util.ConversorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public List<Trip> findAll(){
        return tripRepository.findAll();
    }

    public TripOutputDto save (TripInputDto input){

        return ConversorMapper.convert(
                tripRepository.save(
                        ConversorMapper.convert(
                                input,Trip.class
                        )
                ),
                TripOutputDto.class);
    }

    public TripOutputDto findById(Long tripId) {
        return ConversorMapper.convert(tripRepository.findById(tripId).get(), TripOutputDto.class);
    }
}
