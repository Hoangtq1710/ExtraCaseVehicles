package commons.validation.vehicle_validation;

import java.util.regex.Pattern;

public class YearManuValidation {
    private static final String YEAR_REGEX = "^19[\\d]{2}|20[0-1][\\d]|2020$";
    public static boolean yearValidate(String year) {
        return Pattern.matches(YEAR_REGEX,year);
    }
}
