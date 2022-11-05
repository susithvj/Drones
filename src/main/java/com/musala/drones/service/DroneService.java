package com.musala.drones.service;

import com.musala.drones.dto.DroneDTO;

import java.util.List;

public interface DroneService {
    List<DroneDTO> getAllDrones();

    DroneDTO registerDrone(DroneDTO droneDTO);
}
