package com.musala.drones.service;

import com.musala.drones.dto.DroneDTO;
import com.musala.drones.dto.MedicationDTO;

import java.util.List;

public interface DroneService {
    List<DroneDTO> getAllDrones();

    DroneDTO registerDrone(DroneDTO droneDTO);

    DroneDTO loadMedications(String droneSerialNo, List<MedicationDTO> medications);

    DroneDTO getDroneBySerialNo(String serialNo);

    List<DroneDTO> getAllAvailableDronesByWeight(List<MedicationDTO> medicationDTO);

    void updateDrone(DroneDTO droneDTO);
}
