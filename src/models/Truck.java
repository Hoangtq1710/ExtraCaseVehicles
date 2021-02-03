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
        this.setIdVehicle(truckInfo[0]);
        this.setIdManu(truckInfo[1]);
        this.setNameManu(truckInfo[2]);
        this.setCountry(truckInfo[3]);
        this.setYearManu(truckInfo[4]);
        this.setOwner(truckInfo[5]);
        this.payload = Double.parseDouble(truckInfo[6]);
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
