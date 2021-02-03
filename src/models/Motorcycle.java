package models;

public class Motorcycle extends Vehicles {
    private int wattage; // mã lực

    public Motorcycle() {
    }

    public Motorcycle(String idVehicle, String manufacture, String yearManu, String owner, int wattage) {
        super(idVehicle, manufacture, yearManu, owner);
        this.wattage = wattage;
    }

    public Motorcycle(String[] motoInfo) {
        super(motoInfo[0],motoInfo[1], motoInfo[2], motoInfo[3]);
        this.wattage = Integer.parseInt(motoInfo[4]);
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return super.toString() + "," + wattage;
    }

    @Override
    public String showInfor() {
        return "Motorcycle" + "\n" +
                super.showInfor() +
                ", Wattage " + wattage + "\n";
    }
}
