package com.techreturners;

public class MissionControl {

    private static final int MAX_VEHICLE_COUNT = 7;
    private static int vehicleCount = 0;

    public void deployVehicle(String type, String model) {
        if (vehicleCount <= MAX_VEHICLE_COUNT) {
            new Vehicle(type, model);
            vehicleCount += 1;
        } else {
            throw new IllegalStateException("Maximum number of vehicles deployed reached");
        }
    }

    public int getVehicleCount() {
        return vehicleCount;
    }
}
