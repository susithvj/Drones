package com.musala.drones.service;

import com.musala.drones.dto.DroneDTO;
import com.musala.drones.dto.MedicationDTO;
import com.musala.drones.entity.Medication;

import java.util.List;
import java.util.Set;

public interface DroneService {
    List<DroneDTO> getAllDrones();

    DroneDTO registerDrone(DroneDTO droneDTO);

    DroneDTO loadMedications(String droneSerialNo, List<MedicationDTO> medications);

}
