package services;

import commons.read_write.ReadAndWrite;
import models.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckManagement implements CRUDInterfaces<Truck> {
    static ReadAndWrite<Truck> readAndWrite = new ReadAndWrite<>();
    @Override
    public void add(Truck truck) {
        List<Truck> list = new ArrayList<>();
        list.add(truck);
        readAndWrite.writeToFile("truck.csv", list, true);
    }

    @Override
    public void addAll(List<Truck> list) {
        readAndWrite.writeToFile("truck.csv",list,false);
    }

    @Override
    public List<Truck> findAll() {
        List<String[]> list = readAndWrite.readFromFile("truck.csv");
        List<Truck> listTruck = new ArrayList<>();
        for(String[] line : list) {
            Truck truck = new Truck(line);
            listTruck.add(truck);
        }
        return listTruck;
    }
}
