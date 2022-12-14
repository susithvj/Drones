package com.musala.drones.service.impl;

import com.musala.drones.dto.MedicationDTO;
import com.musala.drones.entity.Drone;
import com.musala.drones.entity.Medication;
import com.musala.drones.exceptions.AlreadyExistException;
import com.musala.drones.exceptions.DroneNotFoundException;
import com.musala.drones.repository.DroneRepository;
import com.musala.drones.service.DroneService;
import com.musala.drones.util.DroneStates;
import com.musala.drones.util.Mapper;
import com.musala.drones.dto.DroneDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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
        allDrones.stream().forEach(drone ->
                allDroneDTO.add(mapper.convert(drone,DroneDTO.class))
        );
        return allDroneDTO;
    }

    @Override
    public DroneDTO getDroneBySerialNo(String serialNo) {
        return mapper.convert(droneRepository.getDroneBySerialNo(serialNo).get(), DroneDTO.class);
    }

    @Override
    public List<DroneDTO> getAllAvailableDronesByWeight(List<MedicationDTO> medicationDTO) {
        List<Drone> allDrones = droneRepository.findAll();
        List<DroneDTO> availableDroneDTO = new ArrayList<>();
        allDrones.stream().forEach(drone -> {
            if(medicationDTO!=null) {
                Double checkingWeight = medicationDTO.stream().mapToDouble(MedicationDTO::getWeight).sum();
                Double currentWeight = drone.getMedications().stream().mapToDouble(Medication::getWeight).sum();

                if((drone.getWeightLimit()-currentWeight)>=checkingWeight) {
                    availableDroneDTO.add(mapper.convert(drone,DroneDTO.class));
                }

            } else {
                Double currentWeight = drone.getMedications().stream().mapToDouble(Medication::getWeight).sum();
                if(drone.getWeightLimit()>currentWeight) {
                    availableDroneDTO.add(mapper.convert(drone,DroneDTO.class));
                }
            }
        });
        return availableDroneDTO;
    }

    @Override
    public void updateDrone(DroneDTO droneDTO) {
        droneRepository.save(mapper.convert(droneDTO, Drone.class));
    }

    @Override
    public DroneDTO registerDrone(DroneDTO droneDTO) {
        if(!isDroneExist(droneDTO.getSerialNo())) {
            return mapper.convert(droneRepository.save(mapper.convert(droneDTO, Drone.class)), DroneDTO.class);
        } else {
            throw new AlreadyExistException("Drone serial no: " + droneDTO.getSerialNo() + "already exists");
        }
    }

    @Override
    public DroneDTO loadMedications(String droneSerialNo, List<MedicationDTO> medications) {
        Optional<Drone> droneOptional =  droneRepository.getDroneBySerialNo(droneSerialNo);
        if(droneOptional.isPresent()) {
            Drone drone = droneOptional.get();
            List<Medication> newMedications = new ArrayList<>();
            medications.stream().forEach(medicationDTO -> newMedications.add(mapper.convert(medicationDTO, Medication.class)));
            drone.setMedications(newMedications);
            Double currentWeight = drone.getMedications().stream().mapToDouble(Medication::getWeight).sum();
            if(currentWeight.doubleValue()==0) {
                drone.setState(DroneStates.IDLE);
            }
            if(currentWeight.doubleValue()>0 && currentWeight.doubleValue()<drone.getWeightLimit().doubleValue()) {
                drone.setState(DroneStates.LOADING);
            }
            if(currentWeight.doubleValue()==drone.getWeightLimit().doubleValue()) {
                drone.setState(DroneStates.LOADED);
            }
            return mapper.convert(droneRepository.save(drone), DroneDTO.class);
        } else {
            throw new DroneNotFoundException("Drone not found. Serial no: " + droneSerialNo);
        }
    }

    private boolean isDroneExist(String serialNo) {
        return droneRepository.getDroneBySerialNo(serialNo).isPresent();
    }
}
