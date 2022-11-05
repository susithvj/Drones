package com.musala.drones.controller.api;

import dto.DroneDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
}
