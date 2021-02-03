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
        super(carInfo[0],carInfo[1], carInfo[2],carInfo[3]);
        this.numSeat = Integer.parseInt(carInfo[4]);
        this.typeCar = carInfo[5];
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
                ", Type of Car " + this.typeCar + "\n";
    }
}
