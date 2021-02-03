package commons.validation.vehicle_validation;

import java.util.regex.Pattern;

public class WattageValidation {
    private static final String WATTAGE_REGEX = "^[1-9]|[1-9][\\d]|[1-4][\\d]{2}$";
    public static boolean wattageValidate(int wattage) {
        return Pattern.matches(WATTAGE_REGEX, Integer.toString(wattage));
    }
}
