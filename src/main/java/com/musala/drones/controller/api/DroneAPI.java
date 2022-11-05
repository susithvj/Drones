package com.musala.drones.controller.api;

import com.musala.drones.dto.DroneDTO;
import com.musala.drones.dto.MedicationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Tag(name = "Drones", description = "Drones API")
@RequestMapping("/api/musalasoft/v1")
public interface DroneAPI {
    @Operation(summary = "Get a drone by drone serial no")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the drone",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DroneDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Drone is not found",
                    content = @Content)
    })

    @GetMapping("/drones/all")
    ResponseEntity<List<DroneDTO>> getAllDrones();

    @GetMapping("/drone/{serialNo}")
    ResponseEntity<DroneDTO> getDroneBySerialNo(@PathVariable String serialNo);

    @Operation(summary = "Register a new drone")
    @PostMapping("/drone/register")
    ResponseEntity<DroneDTO> registerDrone(@Valid @RequestBody DroneDTO droneDTO);

    @Operation(summary = "Loading medication to a drone")
    @PostMapping("/drone/{serialNo}/load")
    ResponseEntity<DroneDTO> loadMedication(@PathVariable String serialNo, @Valid @RequestBody List<MedicationDTO> medicationDTO);
}
