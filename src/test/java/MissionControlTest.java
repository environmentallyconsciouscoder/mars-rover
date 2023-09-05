import com.techreturners.MissionControl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissionControlTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/vehicle.csv")
    public void testDeployVehicle(String vehicleType, String model, String score) {

        MissionControl missionControl = new MissionControl();
        missionControl.deployVehicle(vehicleType, model);

        assertEquals(Integer.parseInt(score), missionControl.getVehicleCount());
    }

    //create a plateau
}
