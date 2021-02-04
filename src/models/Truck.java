package models;

public class Truck extends Vehicles {
    private double payload; // trọng tải (T : ton)

    public Truck() {
    }

    public Truck(String idVehicle, String manufacture, String yearManu, String owner, double payload) {
        super(idVehicle, manufacture, yearManu, owner);
        this.payload = payload;
    }

    public Truck(String[] truckInfo) {
        super(truckInfo[0], truckInfo[1], truckInfo[2], truckInfo[3]);
        this.payload = Double.parseDouble(truckInfo[4]);
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return super.toString() + "," + payload;
    }

    @Override
    public String showInfor() {
        return "Truck\n" +
                super.showInfor() +
                ", Payload " + this.payload;
    }
}
