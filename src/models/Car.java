package models;

public class Car extends Vehicles {
    private int numSeat; // số ghế ngồi
    private String typeCar; // loại xe

    public Car() {
    }

    public Car(String idVehicle, String manufacture, String yearManu, String owner, int numSeat, String typeCar) {
        super(idVehicle, manufacture, yearManu, owner);
        this.numSeat = numSeat;
        this.typeCar = typeCar;
    }

    public Car(String[] carInfo) {
        this.setIdVehicle(carInfo[0]);
        this.setIdManu(carInfo[1]);
        this.setNameManu(carInfo[2]);
        this.setCountry(carInfo[3]);
        this.setYearManu(carInfo[4]);
        this.setOwner(carInfo[5]);
        this.numSeat = Integer.parseInt(carInfo[6]);
        this.typeCar = carInfo[7];
    }

    public int getNumSeat() {
        return numSeat;
    }

    public void setNumSeat(int numSeat) {
        this.numSeat = numSeat;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String toString() {
        return super.toString() + "," + numSeat + "," + typeCar;
    }

    @Override
    public String showInfor() {
        return "Car\n" +
                super.showInfor() +
                ", Num Seat " + this.numSeat +
                ", Type of Car " + this.typeCar;
    }
}
