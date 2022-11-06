package com.musala.drones.service.impl;

import com.musala.drones.dto.DroneDTO;
import com.musala.drones.service.DroneService;
import com.musala.drones.util.DroneStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

@Component
public class SchedulingServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulingServiceImpl.class);

    private DroneService droneService;

    public SchedulingServiceImpl(DroneService droneService) {
        this.droneService = droneService;
    }

    @Scheduled(cron="${scheduler.battery.check.cronExpression:0 0 0 * * MON-FRI}")
    public void checkBatteryLevels() {
        LOGGER.info("Drone battery check scheduler start at "+ new Date());
        List<DroneDTO> drones = droneService.getAllDrones();
        if(drones!=null) {
            drones.stream().forEach(droneDTO -> {
                LOGGER.info("Battery level of drone : "+droneDTO.getSerialNo()+" = "+droneDTO.getBatteryCapacity()+"%");
                if(droneDTO.getBatteryCapacity()<25.0){
                    LOGGER.info("Battery level of drone : "+droneDTO.getSerialNo()+" is less than 25%. Switching to IDLE state");
                    droneDTO.setState(DroneStates.IDLE);
                    droneService.updateDrone(droneDTO);
                }
            });
        }
        LOGGER.info("Drone battery check scheduler end at "+ new Date());
    }
}
