package com.techreturners;

public class Vehicle implements ControlSystem  {
    private final String vehicleType;
    private final String vehicleId;
    private Position position;

    public Vehicle(String vehicleType, String vehicleId, int xValue, int yValue, char convertedChar) {
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.position = new Position(xValue, yValue, convertedChar);
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
        int newValue;
        switch (cardinalDirection) {
            case 'N' -> {
                newValue = vehicle.position.getyValue() + 1;
                vehicle.position.setYValue(newValue);
            }
            case 'E' -> {
                newValue = vehicle.position.getxValue() + 1;
                vehicle.position.setXValue(newValue);
            }
            case 'W' -> {
                newValue = vehicle.position.getxValue() - 1;
                vehicle.position.setXValue(newValue);
            }
            case 'S' -> {
                newValue = vehicle.position.getyValue() - 1;
                vehicle.position.setYValue(newValue);
            }
            default -> System.out.println("Invalid direction");
        }
    }
}
