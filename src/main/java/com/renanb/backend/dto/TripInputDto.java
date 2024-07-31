package com.renanb.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TripInputDto {

    @NotBlank
    private String tripName;
    @NotBlank
    private String description;

}
