package com.musala.drones.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DroneStates {
    @JsonProperty("IDLE")
    IDLE,
    @JsonProperty("LOADING")
    LOADING,
    @JsonProperty("LOADED")
    LOADED,
    @JsonProperty("DELIVERING")
    DELIVERING,
    @JsonProperty("DELIVERED")
    DELIVERED,
    @JsonProperty("RETURNING")
    RETURNING;
}
