package com.renanb.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TripOutputDto {
    private Long tripId;
    private String tripName;
    private String description;
    private byte[] picture;
}
