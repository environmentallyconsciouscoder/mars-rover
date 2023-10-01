package com.techreturners;

import com.techreturners.plateau.Plateau;

import java.util.HashMap;
import java.util.Objects;

import static com.techreturners.MissionControl.getDeployedVehicles;

public class Vehicle implements ControlSystem  {

    private final String vehicleType;
    private final String vehicleId;
    private Position position;
    private Plateau plateau;

    private static final int MOVE_FORWARD_INCREMENT = 1;

    public Vehicle(String vehicleType, String vehicleId, int xValue, int yValue, char cardinalDirection) {
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.position = new Position(xValue, yValue, cardinalDirection);

        this.plateau = new Plateau(0, 5, 0, 5);
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

    @Override
    public void turnRight(Vehicle vehicle, char cardinalDirection) {

        switch (cardinalDirection) {
            case 'N' -> vehicle.position.setCardinalDirection('E');
            case 'E' -> vehicle.position.setCardinalDirection('S');
            case 'W' -> vehicle.position.setCardinalDirection('N');
            case 'S' -> vehicle.position.setCardinalDirection('W');
            default -> System.out.println("Invalid direction");
        }

    }

    @Override
    public void turnLeft(Vehicle vehicle, char cardinalDirection) {
        switch (cardinalDirection) {
            case 'N' -> vehicle.position.setCardinalDirection('W');
            case 'E' -> vehicle.position.setCardinalDirection('N');
            case 'W' -> vehicle.position.setCardinalDirection('S');
            case 'S' -> vehicle.position.setCardinalDirection('E');
            default -> System.out.println("Invalid direction");
        }
    }

    @Override
    public void moveForward(Vehicle vehicle, char cardinalDirection) {
        int newCoordinateValue;
        switch (cardinalDirection) {
            case 'N' -> {
                newCoordinateValue = vehicle.position.getYValue() + MOVE_FORWARD_INCREMENT;
                System.out.println(newCoordinateValue);

                if (isMoveWithinBounds(newCoordinateValue, 'Y') && !isThereCollision(vehicle, newCoordinateValue, 'Y')) {
                    vehicle.position.setYValue(newCoordinateValue);
                }
            }
            case 'E' -> {
                newCoordinateValue = vehicle.position.getXValue() + MOVE_FORWARD_INCREMENT;
                if (isMoveWithinBounds(newCoordinateValue, 'X') && !isThereCollision(vehicle, newCoordinateValue, 'X')) {
                    vehicle.position.setXValue(newCoordinateValue);
                }
            }
            case 'W' -> {
                newCoordinateValue = vehicle.position.getXValue() - MOVE_FORWARD_INCREMENT;
                if (isMoveWithinBounds(newCoordinateValue, 'X') && !isThereCollision(vehicle, newCoordinateValue, 'X')) {
                    vehicle.position.setXValue(newCoordinateValue);
                }
            }
            case 'S' -> {
                newCoordinateValue = vehicle.position.getYValue() - MOVE_FORWARD_INCREMENT;
                if (isMoveWithinBounds(newCoordinateValue, 'Y') && !isThereCollision(vehicle, newCoordinateValue, 'Y')) {
                    vehicle.position.setYValue(newCoordinateValue);
                }
            }
            default -> System.out.println("Invalid direction");
        }
    }

    @Override
    public boolean isThereCollision(Vehicle vehicle, int newCoordinateValue, char axis) {

        int vehicleYValue = axis == 'Y' ? newCoordinateValue: vehicle.getPosition().getYValue();
        int vehicleXValue = axis == 'X' ? newCoordinateValue: vehicle.getPosition().getXValue();
        String vehicleId = vehicle.getVehicleId();

        HashMap<String, Object> allDeployedVehicles = getDeployedVehicles();
        boolean result = false;
        for (String key : allDeployedVehicles.keySet()) {
            if (!Objects.equals(key, vehicleId)) {
                Object value = allDeployedVehicles.get(key);
                if (value instanceof Vehicle otherVehicle) {
                    if (vehicleXValue == otherVehicle.getPosition().getXValue() && vehicleYValue == otherVehicle.getPosition().getYValue()) {
                        result = true;
                    }
                }
            }
        }
         return result;
     }

     public boolean isMoveWithinBounds(int newCoordinateValue, char axis) {
        boolean isWithinBounds = false;

        if (Objects.equals(axis, 'X')) {
            isWithinBounds = newCoordinateValue >= plateau.getMinX() && newCoordinateValue <= plateau.getMaxX();
        } else if (Objects.equals(axis, 'Y')) {
            isWithinBounds = newCoordinateValue >= plateau.getMinY() && newCoordinateValue <= plateau.getMaxY();
        } else {
            System.out.println("Invalid axis");
        }

        return isWithinBounds;
    }
}
