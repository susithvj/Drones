package com.musala.drones.service.impl;

import com.musala.drones.entity.Drone;
import com.musala.drones.repository.DroneRepository;
import com.musala.drones.service.DroneService;
import com.musala.drones.util.Mapper;
import dto.DroneDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class DroneServiceImpl implements DroneService {
    private final DroneRepository droneRepository;
    private final Mapper mapper;

    public DroneServiceImpl(DroneRepository droneRepository, Mapper mapper) {
        this.droneRepository = droneRepository;
        this.mapper = mapper;
    }

    @Override
    public List<DroneDTO> getAllDrones() {
        List<Drone> allDrones = droneRepository.findAll();
        List<DroneDTO> allDroneDTO = new ArrayList<>();
        allDrones.stream().forEach(drone -> allDroneDTO.add(mapper.convert(drone,DroneDTO.class)));
        return allDroneDTO;
    }
}
