package com.musala.drones.config;

import com.musala.drones.entity.Drone;
import com.musala.drones.entity.Medication;
import com.musala.drones.repository.DroneRepository;
import com.musala.drones.repository.MedicationRepository;
import com.musala.drones.util.DroneStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadInitialDatabase {
    private static final Logger logger = LoggerFactory.getLogger(LoadInitialDatabase.class);

    @Bean
    CommandLineRunner initDatabase(DroneRepository droneRepository, MedicationRepository medicationRepository) {
        return args -> {
            //pre-loading drones into database
            logger.info("PRE-LOADING-DRONES = " + droneRepository.save(new Drone("DRONE001", "TRANSPORTER", 500.0, 100.0, DroneStates.IDLE)));
            logger.info("PRE-LOADING-DRONES = " + droneRepository.save(new Drone("DRONE002", "TRANSPORTER", 500.0, 100.0, DroneStates.IDLE)));
            logger.info("PRE-LOADING-DRONES = " + droneRepository.save(new Drone("DRONE003", "TRANSPORTER", 500.0, 100.0, DroneStates.IDLE)));
            logger.info("PRE-LOADING-DRONES = " + droneRepository.save(new Drone("DRONE004", "TRANSPORTER", 500.0, 100.0, DroneStates.IDLE)));
            logger.info("PRE-LOADING-DRONES = " + droneRepository.save(new Drone("DRONE05", "TRANSPORTER", 500.0, 100.0, DroneStates.IDLE)));
            logger.info("PRE-LOADING-DRONES = " + droneRepository.save(new Drone("DRONE06", "TRANSPORTER", 500.0, 100.0, DroneStates.IDLE)));
            logger.info("PRE-LOADING-DRONES = " + droneRepository.save(new Drone("DRONE07", "TRANSPORTER", 500.0, 100.0, DroneStates.IDLE)));
            logger.info("PRE-LOADING-DRONES = " + droneRepository.save(new Drone("DRONE08", "TRANSPORTER", 500.0, 100.0, DroneStates.IDLE)));
            logger.info("PRE-LOADING-DRONES = " + droneRepository.save(new Drone("DRONE09", "TRANSPORTER", 500.0, 100.0, DroneStates.IDLE)));
            logger.info("PRE-LOADING-DRONES = " + droneRepository.save(new Drone("DRONE10", "TRANSPORTER", 500.0, 100.0, DroneStates.IDLE)));

            //pre-loading medication into database
            logger.info("PRE-LOADING-DRONES = " + medicationRepository.save(new Medication("Amlodipine", 200.0, "MED-01-01", null)));
            logger.info("PRE-LOADING-DRONES = " + medicationRepository.save(new Medication("Amitriptyline", 100.0, "MED-01-02", null)));
            logger.info("PRE-LOADING-DRONES = " + medicationRepository.save(new Medication("Fentanyl", 25.0, "MED-02-03", null)));
            logger.info("PRE-LOADING-DRONES = " + medicationRepository.save(new Medication("Melatonin", 50.0, "MED-03-04", null)));
            logger.info("PRE-LOADING-DRONES = " + medicationRepository.save(new Medication("Metoprolol", 100.0, "MED-03-05", null)));
        };
    }
}
