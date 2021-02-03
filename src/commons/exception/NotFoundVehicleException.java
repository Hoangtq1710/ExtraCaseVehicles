package commons.exception;

public class NotFoundVehicleException extends Exception{
    public NotFoundVehicleException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
