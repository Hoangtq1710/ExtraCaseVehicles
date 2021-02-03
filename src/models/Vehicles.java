package models;

public abstract class Vehicles {
    private String idVehicle;
    private String manufacture;
    private String idManu;
    private String nameManu;
    private String country;
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

    public String getIdManu() {
        return idManu;
    }

    public void setIdManu(String idManu) {
        this.idManu = idManu;
    }

    public String getNameManu() {
        return nameManu;
    }

    public void setNameManu(String nameManu) {
        this.nameManu = nameManu;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
                ", IDManu " + this.idManu +
                ", NameManu "+ this.nameManu+
                ", Country "+ this.country+
                ", Year " + yearManu +
                ", Owner by " + owner;
    }
}
