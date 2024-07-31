package com.renanb.backend.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renanb.backend.dto.TripInputDto;
import com.renanb.backend.dto.TripOutputDto;
import com.renanb.backend.model.Trip;
import lombok.SneakyThrows;

public class ConversorMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @SneakyThrows
    public static <InputType, OutputType> OutputType convert(InputType input, Class<OutputType> output){
        return objectMapper.convertValue(input, output);
    }

    public static TripOutputDto convertTripToDto(Trip trip){
        TripOutputDto dto = ConversorMapper.convert(trip, TripOutputDto.class);

        dto.setTripId(trip.getTripId());
        dto.setTripName(trip.getTripName());
        dto.setDescription(trip.getDescription());
        dto.setPicture(trip.getPicture());

        return dto;
    }
    public static Trip convertDtoToTrip(TripInputDto tripDto){
        Trip trip = ConversorMapper.convert(tripDto, Trip.class);

        trip.setTripName(tripDto.getTripName());
        trip.setDescription(tripDto.getDescription());

        return trip;
    }
}
