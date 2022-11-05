package com.musala.drones.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class MedicationDTO {
    private Long id;
    private String name;
    private Double weight;
    @NotEmpty(message = "Medication code cannot be empty")
    private String code;
    private Byte[] image;
}
