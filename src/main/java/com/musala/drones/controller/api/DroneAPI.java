package com.musala.drones.controller.api;

import com.musala.drones.dto.DroneDTO;
import com.musala.drones.dto.MedicationDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Drones", description = "Drones API")
@SecurityScheme(
        name = "basicAuth", // can be set to anything
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@OpenAPIDefinition(
        security = @SecurityRequirement(name = "basicAuth") // references the name defined in the line 3
)
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

    @GetMapping("/drones/availability/all")
    ResponseEntity<List<DroneDTO>> getAllAvailableDrones();

    @PostMapping("/drones/availability/check")
    ResponseEntity<List<DroneDTO>> getAllAvailableDronesByWeight(@Valid @RequestBody List<MedicationDTO> medicationDTO);

    @Operation(summary = "Register a new drone")
    @PostMapping("/drone/register")
    ResponseEntity<DroneDTO> registerDrone(@Valid @RequestBody DroneDTO droneDTO);

    @Operation(summary = "Loading medication to a drone")
    @PostMapping("/drone/{serialNo}/load")
    ResponseEntity<DroneDTO> loadMedication(@PathVariable String serialNo, @Valid @RequestBody List<MedicationDTO> medicationDTO);
}
