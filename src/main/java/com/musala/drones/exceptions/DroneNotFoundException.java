package com.musala.drones.exceptions;

public class DroneNotFoundException extends RuntimeException {
    public DroneNotFoundException(String message) {
        super(message);
    }
}
