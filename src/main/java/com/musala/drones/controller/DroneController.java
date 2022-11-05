package com.musala.drones.controller;

import com.musala.drones.controller.api.DroneAPI;
import com.musala.drones.dto.MedicationDTO;
import com.musala.drones.service.DroneService;
import com.musala.drones.dto.DroneDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

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

    @Override
    public ResponseEntity<DroneDTO> getDroneBySerialNo(String serialNo) {
        return new ResponseEntity<>(droneService.getDroneBySerialNo(serialNo), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DroneDTO> registerDrone(@Valid DroneDTO droneDTO) {
        return new ResponseEntity<>(droneService.registerDrone(droneDTO),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DroneDTO> loadMedication(String serialNo, @Valid List<MedicationDTO> medicationDTO) {
        return new ResponseEntity<>(droneService.loadMedications(serialNo, medicationDTO),HttpStatus.OK);
    }
}
