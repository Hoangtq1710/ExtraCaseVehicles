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
        this.setIdVehicle(motoInfo[0]);
        this.setIdManu(motoInfo[1]);
        this.setNameManu(motoInfo[2]);
        this.setCountry(motoInfo[3]);
        this.setYearManu(motoInfo[4]);
        this.setOwner(motoInfo[5]);
        this.wattage = Integer.parseInt(motoInfo[6]);
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
                ", Wattage " + wattage;
    }
}
