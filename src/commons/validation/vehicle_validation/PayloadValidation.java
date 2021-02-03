package commons.validation.vehicle_validation;

import java.util.regex.Pattern;

public class PayloadValidation {
    private static final String PAYLOAD_REGEX = "^[\\d]+\\.[\\d]+$";
    public static boolean payloadValidate(double payload) {
        return Pattern.matches(PAYLOAD_REGEX, Double.toString(payload));
    }
}
