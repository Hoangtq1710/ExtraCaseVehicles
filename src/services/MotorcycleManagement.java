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
        readAndWrite.writeToFile("motorcycle.csv",list,true);
    }

    @Override
    public void addAll(List<Motorcycle> list) {
        readAndWrite.writeToFile("motorcycle.csv",list,false);
    }

    @Override
    public List<Motorcycle> findAll() {
        List<String[]> list = readAndWrite.readFromFile("motorcycle.csv");
        List<Motorcycle> listMotor = new ArrayList<>();
        for(String[] line : list) {
            Motorcycle motorcycle = new Motorcycle(line);
            listMotor.add(motorcycle);
        }
        return listMotor;
    }
}
