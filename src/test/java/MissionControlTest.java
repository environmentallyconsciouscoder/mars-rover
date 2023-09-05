import com.techreturners.MissionControl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissionControlTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/vehicle.csv")
    public void testDeployVehicle(String vehicleType, String model, String score) {

        MissionControl missionControl = new MissionControl();

//        System.out.println(missionControl.getVehicleCount());
//        System.out.println(missionControl.getMaxVehicleCount());
        boolean isNoMoreThanMaxVehicleCount = missionControl.getVehicleCount() < missionControl.getMaxVehicleCount();
//        System.out.println(isNoMoreThanMaxVehicleCount);

        if (isNoMoreThanMaxVehicleCount) {
            missionControl.deployVehicle(vehicleType, model);
//            System.out.println(missionControl.getVehicleCount());
//            System.out.println(Integer.parseInt(score));

            assertEquals(Integer.parseInt(score), missionControl.getVehicleCount());
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

    //create a plateau
}
