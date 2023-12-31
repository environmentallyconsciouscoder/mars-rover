package com.techreturners.vehicle;

import com.techreturners.MissionControl;
import com.techreturners.vehicle.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    @Test
    public void testVehicle() {

        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);

        assertEquals(vehicleType, vehicle.getVehicleType());
        assertEquals(vehicleId, vehicle.getVehicleId());
        assertEquals(xValue, vehicle.getPosition().getXValue());
        assertEquals(yValue, vehicle.getPosition().getYValue());
        assertEquals(cardinalDirection, vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnLeft_NorthToWest() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnLeft(vehicle);
        assertEquals('W', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnLeft_EastToNorth() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'E';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnLeft(vehicle);
        assertEquals('N', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnLeft_WestToSouth() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'W';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnLeft(vehicle);
        assertEquals('S', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnLeft_SouthToEast() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'S';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnLeft(vehicle);
        assertEquals('E', vehicle.getPosition().getCardinalDirection());
    }


    @Test
    public void testTurnRight_NorthToEast() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnRight(vehicle);
        assertEquals('E', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnRight_EastToSouth() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'E';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnRight(vehicle);
        assertEquals('S', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnRight_WestToNorth() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'W';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnRight(vehicle);
        assertEquals('N', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnRight_SouthToWest() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'S';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnRight(vehicle);
        assertEquals('W', vehicle.getPosition().getCardinalDirection());
    }


    @Test
    public void testMoveForwardNorth() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.moveForward(vehicle);
        assertEquals(3, vehicle.getPosition().getYValue());
    }

    @Test
    public void testMoveForwardEast() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'E';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.moveForward(vehicle);
        assertEquals(2, vehicle.getPosition().getXValue());
    }

    @Test
    public void testMoveForwardWest() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'W';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.moveForward(vehicle);
        assertEquals(0, vehicle.getPosition().getXValue());
    }

    @Test
    public void testMoveForwardSouth() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'S';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.moveForward(vehicle);
        assertEquals(1, vehicle.getPosition().getYValue());
    }


    @Test
    public void testIsMoveWithinBounds() {

        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 10;
        int yValue = 20;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);

        int newCoordinateValueTen = 10;
        char yAxis = 'Y';
        char xAxis = 'X';

        boolean isWithinBoundsYAxis = vehicle.isMoveWithinBounds(newCoordinateValueTen, yAxis);
        boolean isWithinBoundsXAxis = vehicle.isMoveWithinBounds(newCoordinateValueTen, xAxis);

        assertEquals(false, isWithinBoundsYAxis);
        assertEquals(false, isWithinBoundsXAxis);

    }


    @Test
    public void testIsThereCollision() {
        MissionControl missionControl = new MissionControl();
        boolean isNotMoreThanMaxVehicleCount = missionControl.getVehicleCount() < missionControl.getMaxVehicleCount();

        if (isNotMoreThanMaxVehicleCount) {
            missionControl.deployVehicle("Mars rover", "MR2", "N", 2, 2);
            missionControl.deployVehicle("Mars rover", "MR3", "N", 0, 2);
            missionControl.deployVehicle("Mars rover", "MR4", "N", 3, 2);

            Vehicle vehicle = new Vehicle("mars rover", "MR1", 0, 3, 'N');
            boolean isThereCollision = vehicle.isThereCollision(vehicle, 3, 'Y');
            assertEquals(false, isThereCollision);
        }
    }
}
