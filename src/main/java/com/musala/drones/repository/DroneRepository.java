package com.musala.drones.repository;

import com.musala.drones.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DroneRepository extends JpaRepository<Drone, Long> {

    Optional<Drone> getDroneBySerialNo(String serialNo);

}
