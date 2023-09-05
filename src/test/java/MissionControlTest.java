import com.techreturners.MissionControl;
import com.techreturners.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissionControlTest {

    private MissionControl missionControl = new MissionControl();


    @ParameterizedTest
    @CsvFileSource(resources = "/vehicle.csv", numLinesToSkip = 1) // Skip the header row
    public void testDeployVehicle(String vehicleType, String vehicleId, String count, String cardinalDirection, String xAxis, String yAxis) {

//        MissionControl missionControl = new MissionControl();

//        System.out.println(missionControl.getVehicleCount());
//        System.out.println(missionControl.getMaxVehicleCount());
        boolean isNoMoreThanMaxVehicleCount = missionControl.getVehicleCount() < missionControl.getMaxVehicleCount();
//        System.out.println(isNoMoreThanMaxVehicleCount);
        int xValue = Integer.parseInt(xAxis);
        int yValue = Integer.parseInt(yAxis);

        if (isNoMoreThanMaxVehicleCount) {
            missionControl.deployVehicle(vehicleType, vehicleId, cardinalDirection, xValue, yValue);
//            System.out.println(missionControl.getVehicleCount());
//            System.out.println(Integer.parseInt(score));

            assertEquals(Integer.parseInt(count), missionControl.getVehicleCount());
        }

    }

    @Test
    public void testMaxVehicleCount() {

        MissionControl missionControl = new MissionControl();

//        System.out.println(missionControl.getVehicleCount());
//        System.out.println(missionControl.getMaxVehicleCount());

        boolean isNoMoreThanMaxVehicleCount = missionControl.getVehicleCount() <= missionControl.getMaxVehicleCount();
//        System.out.println(isNoMoreThanMaxVehicleCount);

        assertEquals(true, isNoMoreThanMaxVehicleCount);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/vehicle.csv", numLinesToSkip = 1)
    public void testSetPosition(String vehicleType, String vehicleId, String count, String cardinalDirection, String xAxis, String yAxis) {


        int xValue = Integer.parseInt(xAxis);
        int yValue = Integer.parseInt(yAxis);

        HashMap<String, Object> deployments = missionControl.getDeployedVehicles();
        Vehicle test = (Vehicle) deployments.get(vehicleId);
        char convertedChar = cardinalDirection.charAt(0);

        assertEquals(vehicleId, test.getVehicleId());
        assertEquals(xValue, test.getPosition().getxValue());
        assertEquals(yValue, test.getPosition().getyValue());
        assertEquals(convertedChar, test.getPosition().getCardinalDirection());


    }
}
