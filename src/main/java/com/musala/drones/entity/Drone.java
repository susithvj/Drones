package com.musala.drones.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Drone {
    private @Id @GeneratedValue Long id;
    private String serialNo;
    private String model;
    private Double weightLimit;
    private Double batteryCapacity;
    private String state;

    public Drone() {}

    public Drone(String serialNo, String model, Double weightLimit, Double batteryCapacity, String state) {
        this.serialNo = serialNo;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drone drone = (Drone) o;
        return Objects.equals(id, drone.id) &&
                Objects.equals(serialNo, drone.serialNo) &&
                Objects.equals(model, drone.model) &&
                Objects.equals(weightLimit, drone.weightLimit) &&
                Objects.equals(batteryCapacity, drone.batteryCapacity) &&
                Objects.equals(state, drone.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNo, model, weightLimit, batteryCapacity, state);
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", serialNo='" + serialNo + '\'' +
                ", model='" + model + '\'' +
                ", weightLimit=" + weightLimit +
                ", batteryCapacity=" + batteryCapacity +
                ", state='" + state + '\'' +
                '}';
    }
}
