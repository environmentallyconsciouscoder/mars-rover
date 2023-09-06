package com.techreturners;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MissionControl {

    private static final int MAX_VEHICLE_COUNT = 4;
    private static int vehicleCount = 0;
    private static HashMap<String, Object> deployments = new HashMap<>();

    public void deployVehicle(String vehicleType, String vehicleId, String cardinalDirection, int xValue, int yValue) {
        if (vehicleCount < MAX_VEHICLE_COUNT) {

            char convertedChar = cardinalDirection.charAt(0);
            deployments.put(vehicleId, new Vehicle(vehicleType, vehicleId, xValue, yValue, convertedChar));

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

    public void executeCommands(String vehicleId, String command) {
    // 1) get the current xValue, yValue and cardinalDirection
    Vehicle vehicle = (Vehicle) deployments.get(vehicleId);

        // 2) break strings down into characters
        for (int i = 0; i < command.length(); i++) {
            char character = command.charAt(i);
            String myString = String.valueOf(character);

            dataProcessor(myString, vehicle);
        }

    }

    private void dataProcessor(String command, Vehicle vehicle) {
        Queue<String> queue = new LinkedList<>();

        // 3) add each character to the queue data structure
        queue.offer(command);

        while (!queue.isEmpty()) {
            char currentCardinalDirection = vehicle.getPosition().getCardinalDirection();

            // 4) retrieves and removes the first element (head) from the queue
            String newDirection = queue.poll();
            if (newDirection != null) {
                checkCommands(newDirection, vehicle, currentCardinalDirection);
            }
        }


    }

    // 5) check the commands
    private void checkCommands(String newDirection, Vehicle vehicle, char currentCardinalDirection) {
        if (newDirection.equals("M")) {
            vehicle.moveForward(vehicle, currentCardinalDirection);
        } else if (newDirection.equals("L")) {
            vehicle.turnLeft(vehicle, currentCardinalDirection);
        } else if (newDirection.equals("R")) {
            vehicle.turnRight(vehicle, currentCardinalDirection);
        } else {
            System.out.println("newDirection is not valid");
        }
    }


}
