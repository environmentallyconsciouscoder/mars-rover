import com.techreturners.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {


      @Test
      public void testVehicle() {

          String vehicleType = "Car";
          String vehicleId = "123";
          int xValue = 10;
          int yValue = 20;
          char convertedChar = 'C';

          Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, convertedChar);

          assertEquals(vehicleType, vehicle.getVehicleType());
          assertEquals(vehicleId, vehicle.getVehicleId());
          assertEquals(xValue, vehicle.getPosition().getXValue());
          assertEquals(yValue, vehicle.getPosition().getYValue());
          assertEquals(convertedChar, vehicle.getPosition().getCardinalDirection());
      }

    @Test
    public void testIsMoveWithinBounds() {

        String vehicleType = "Car";
        String vehicleId = "123";
        int xValue = 10;
        int yValue = 20;
        char convertedChar = 'C';

        Vehicle vehicle = new Vehicle(vehicleType, vehicleId, xValue, yValue, convertedChar);

        int newCoordinateValueTen = 10;
        char yAxis = 'Y';
        char xAxis = 'X';

        boolean isWithinBoundsYAxis = vehicle.isMoveWithinBounds(newCoordinateValueTen, yAxis);
        boolean isWithinBoundsXAxis = vehicle.isMoveWithinBounds(newCoordinateValueTen, xAxis);

        assertEquals(false, isWithinBoundsYAxis);
        assertEquals(false, isWithinBoundsXAxis);

    }
}
