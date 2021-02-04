package models;

public abstract class Vehicles {
    private String idVehicle;
    private String manufacture;
    private String yearManu;
    private String owner;

    public Vehicles() {
    }

    public Vehicles(String idVehicle, String manufacture, String yearManu, String owner) {
        this.idVehicle = idVehicle;
        this.manufacture = manufacture;
        this.yearManu = yearManu;
        this.owner = owner;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getYearManu() {
        return yearManu;
    }

    public void setYearManu(String yearManu) {
        this.yearManu = yearManu;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return idVehicle + "," + manufacture + "," + yearManu + "," + owner;
    }

    public String showInfor() {
        return "ID " + idVehicle +
                ", Manufacture " + this.manufacture +
                ", Year " + yearManu +
                ", Owner by " + owner;
    }
}
