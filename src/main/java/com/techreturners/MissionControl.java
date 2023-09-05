package com.techreturners;

import java.util.HashMap;

public class MissionControl {

    private static final int MAX_VEHICLE_COUNT = 4;
    private static int vehicleCount = 0;
    private static HashMap<String, Object> deployments = new HashMap<>();

    public void deployVehicle(String vehicleType, String vehicleId, String cardinalDirection, int xValue, int yValue) {
        if (vehicleCount < MAX_VEHICLE_COUNT) {
            Vehicle newVehicle = new Vehicle(vehicleType, vehicleId);

            char convertedChar = cardinalDirection.charAt(0);
            newVehicle.setPosition(xValue, yValue, convertedChar);

            deployments.put(vehicleId, newVehicle);

            incrementVehicleCount();
        } else {
            throw new IllegalStateException("Maximum number of vehicles deployed reached");
        }
    }

    public HashMap<String, Object> getDeployedVehicles() {
        return deployments;
    }

    public void incrementVehicleCount() {
        vehicleCount += 1;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public int getMaxVehicleCount() {
        return MAX_VEHICLE_COUNT;
    }
}
