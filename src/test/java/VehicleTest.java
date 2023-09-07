import com.techreturners.Vehicle;
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
        vehicle.turnLeft(vehicle, 'N');
        assertEquals('W', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnLeft_EastToNorth() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnLeft(vehicle, 'E');
        assertEquals('N', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnLeft_WestToSouth() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnLeft(vehicle, 'W');
        assertEquals('S', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnLeft_SouthToEast() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnLeft(vehicle, 'S');
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
        vehicle.turnRight(vehicle, 'N');
        assertEquals('E', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnRight_EastToSouth() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnRight(vehicle, 'E');
        assertEquals('S', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnRight_WestToNorth() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnRight(vehicle, 'W');
        assertEquals('N', vehicle.getPosition().getCardinalDirection());
    }

    @Test
    public void testTurnRight_SouthToWest() {
        String vehicleType = "Mars Rover";
        String vehicleId = "MR10";
        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, cardinalDirection);
        vehicle.turnRight(vehicle, 'S');
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
        vehicle.moveForward(vehicle, cardinalDirection);
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
        vehicle.moveForward(vehicle, cardinalDirection);
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
        vehicle.moveForward(vehicle, cardinalDirection);
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
        vehicle.moveForward(vehicle, cardinalDirection);
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
}
