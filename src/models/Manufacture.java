package models;

public class Manufacture {
    private String idManu;
    private String nameManu;
    private String country;

    public Manufacture() {
    }

    public Manufacture(String idManu, String nameManu, String country) {
        this.idManu = idManu;
        this.nameManu = nameManu;
        this.country = country;
    }

    public Manufacture(String[] manuInfo) {
        this.idManu = manuInfo[0];
        this.nameManu = manuInfo[1];
        this.country = manuInfo[2];
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

    @Override
    public String toString() {
        return idManu+","+nameManu+","+country;
    }
    public String showInfor() {
        return  "ID Manufacture "+idManu+
                ", Name "+nameManu+
                ", Country "+country;
    }
}
