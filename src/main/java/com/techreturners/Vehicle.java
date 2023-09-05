package com.techreturners;

public class Vehicle {
    private final String vehicleType;
    private final String vehicleId;
    private Position position;

    public Vehicle(String vehicleType, String vehicleId) {
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
    }

    public void setPosition(int xValue, int yValue, char cardinalDirection) {
        position = new Position(xValue, yValue, cardinalDirection);
    }

    public Position getPosition() {
        return position;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
