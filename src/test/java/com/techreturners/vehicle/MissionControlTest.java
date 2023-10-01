package com.techreturners.vehicle;

import com.techreturners.MissionControl;
import com.techreturners.vehicle.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissionControlTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/vehicles.csv", numLinesToSkip = 1) // Skip the header row
    public void testDeployVehicle(String vehicleType, String vehicleId, String count, String cardinalDirection, String xAxis, String yAxis) {

        MissionControl missionControl = new MissionControl();
        boolean isNotMoreThanMaxVehicleCount = missionControl.getVehicleCount() < missionControl.getMaxVehicleCount();
        int xValue = Integer.parseInt(xAxis);
        int yValue = Integer.parseInt(yAxis);

        if (isNotMoreThanMaxVehicleCount) {
            missionControl.deployVehicle(vehicleType, vehicleId, cardinalDirection, xValue, yValue);
            assertEquals(Integer.parseInt(count), missionControl.getVehicleCount());
        }

    }

    @Test
    public void testMaxVehicleCount() {

        MissionControl missionControl = new MissionControl();
        boolean isNoMoreThanMaxVehicleCount = missionControl.getVehicleCount() <= missionControl.getMaxVehicleCount();
        assertEquals(true, isNoMoreThanMaxVehicleCount);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/commands.csv", numLinesToSkip = 1)
    public void testExecuteCommands(String vehicleId, String command, String xValue, String yValue, String cardinalDirection) {
        MissionControl missionControl = new MissionControl();
        missionControl.executeCommands(vehicleId, command);

        HashMap<String, Object> deployments = missionControl.getDeployedVehicles();
        Vehicle test = (Vehicle) deployments.get(vehicleId);
        char convertedChar = cardinalDirection.charAt(0);

        assertEquals(Integer.parseInt(xValue), test.getPosition().getXValue());
        assertEquals(Integer.parseInt(yValue), test.getPosition().getYValue());
        assertEquals(convertedChar, test.getPosition().getCardinalDirection());
    }
}
