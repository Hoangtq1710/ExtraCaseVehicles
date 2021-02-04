package services;

import commons.read_write.ReadAndWrite;
import models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarManagement implements CRUDInterfaces<Car> {
    static ReadAndWrite<Car> readAndWrite = new ReadAndWrite<>();

    @Override
    public void add(Car car) {
        List<Car> list = new ArrayList<>();
        list.add(car);
        readAndWrite.writeToFile("car.csv", list, true);
    }

    @Override
    public void addAll(List<Car> list) {
        readAndWrite.writeToFile("car.csv", list, false);
    }

    @Override
    public List<Car> findAll() {
        List<String[]> list = readAndWrite.readFromFile("car.csv");
        List<Car> listCar = new ArrayList<>();
        for(String[] line : list) {
            Car car = new Car(line);
            listCar.add(car);
        }
        return listCar;
    }
}
