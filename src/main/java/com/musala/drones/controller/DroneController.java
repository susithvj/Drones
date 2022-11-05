package com.musala.drones.controller;

import com.musala.drones.controller.api.DroneAPI;
import com.musala.drones.service.DroneService;
import dto.DroneDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DroneController implements DroneAPI {

    private final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @Override
    public ResponseEntity<List<DroneDTO>> getAllDrones() {
        return new ResponseEntity<>(droneService.getAllDrones(), HttpStatus.OK);
    }
}
