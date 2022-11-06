package com.musala.drones.dto;

import com.musala.drones.util.DroneStates;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class DroneDTO {
    private Long id;
    @NotEmpty(message = "Drone serial no cannot be empty")
    private String serialNo;
    private String model;
    private Double weightLimit;
    private Double batteryCapacity;
    private DroneStates state;
    private List<MedicationDTO> medications;
}
