package commons.validation.vehicle_validation;

import java.util.regex.Pattern;

public class IdVehicleValidation {

    private static final String ID_TRUCK_REGEX = "^[\\d]{2}C-[\\d]{3}\\.[\\d]{2}$";
    private static final String ID_CAR_REGEX = "^[\\d]{2}[AB]-[\\d]{3}\\.[\\d]{2}$";
    private static final String ID_MOTOR_REGEX = "^[\\d]{2}-[A-Z]([A-Z]|[\\d])-[\\d]{3}\\.[\\d]{2}$";
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
