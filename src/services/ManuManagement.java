package services;

import commons.read_write.ReadAndWrite;
import models.Manufacture;

import java.util.ArrayList;
import java.util.List;

public class ManuManagement implements CRUDInterfaces<Manufacture>{
    static ReadAndWrite<Manufacture> readAndWrite = new ReadAndWrite<>();
    @Override
    public void add(Manufacture manufacture) {
        List<Manufacture> list = new ArrayList<>();
        list.add(manufacture);
        readAndWrite.writeToFile("manufacture.csv",list,true);
    }

    @Override
    public void addAll(List<Manufacture> list) {
        readAndWrite.writeToFile("manufacture.csv",list,false);
    }

    @Override
    public List<Manufacture> findAll() {
        List<String[]> list = readAndWrite.readFromFile("manufacture.csv");
        List<Manufacture> listManu = new ArrayList<>();
        for(String[] line : list) {
            Manufacture manufacture = new Manufacture(line);
            listManu.add(manufacture);
        }
        return listManu;
    }
    public void showManu(List<Manufacture> list) {
        int i = 1;
        for(Manufacture manufacture : list) {
            System.out.println((i+". "+manufacture.showInfor()));
            i++;
        }
    }
}
