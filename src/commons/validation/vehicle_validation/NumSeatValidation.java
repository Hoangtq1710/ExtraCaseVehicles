package commons.validation.vehicle_validation;

import java.util.regex.Pattern;

public class NumSeatValidation {
    private static final String NUMSEAT_REGEX = "^[1-9]|1[\\d]$";
    public static boolean numSeatValidate(int numSeat) {
        return Pattern.matches(NUMSEAT_REGEX,Integer.toString(numSeat));
    }
}
