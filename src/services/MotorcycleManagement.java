package services;

import commons.read_write.ReadAndWrite;
import models.Motorcycle;

import java.util.ArrayList;
import java.util.List;

public class MotorcycleManagement implements CRUDInterfaces<Motorcycle> {
    static ReadAndWrite<Motorcycle> readAndWrite = new ReadAndWrite<>();
    @Override
    public void add(Motorcycle motorcycle) {
        List<Motorcycle> list = new ArrayList<>();
        list.add(motorcycle);
        readAndWrite.writeVehicleToFile("motorcycle.csv",list,true);
    }

    @Override
    public List<Motorcycle> findAll() {
        List<String[]> list = readAndWrite.readVehicleFromFile("motorcycle.csv");
        List<Motorcycle> listMotor = new ArrayList<>();
        for(String[] line : list) {
            Motorcycle motorcycle = new Motorcycle(line);
            listMotor.add(motorcycle);
        }
        return listMotor;
    }
}
