package commons.validation.vehicle_validation;

import java.util.regex.Pattern;

public class IdVehicleValidation {

    private static final String ID_TRUCK_REGEX = "";
    private static final String ID_CAR_REGEX = "";
    private static final String ID_MOTOR_REGEX = "";
    public static boolean IdVehicleValidate(int typeVehicle, String id) {
        String regex = "";
        switch (typeVehicle) {
            case 1:
                regex = ID_TRUCK_REGEX;
                break;
            case 2:
                regex = ID_CAR_REGEX;
                break;
            case 3:
                regex = ID_MOTOR_REGEX;
                break;
        }
        return Pattern.matches(regex,id);
    }
}
