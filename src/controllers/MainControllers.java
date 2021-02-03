package controllers;

import commons.read_write.ReadAndWrite;
import models.Car;
import models.Motorcycle;
import models.Truck;
import services.CarManagement;
import services.MotorcycleManagement;
import services.TruckManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainControllers {
    static Scanner scanner = new Scanner(System.in);

    private static final int TRUCK = 1;
    private static final int CAR = 2;
    private static final int MOTORCYCLE = 3;

    static CarManagement carManagement = new CarManagement();
    static TruckManagement truckManagement = new TruckManagement();
    static MotorcycleManagement motorcycleManagement = new MotorcycleManagement();

    private static void displayMainMenu() {
        while (true) {
            System.out.println("\n----VEHICLE MENU----\n" +
                    "1. Add New Vehicle\n" +
                    "2. Show Vehicle\n" +
                    "3. Delete Vehicle\n" +
                    "0. Exit\n");
            int choiceMenu;
            System.out.print("Your choice is : ");
            choiceMenu = Integer.parseInt(scanner.nextLine());
            switch (choiceMenu) {
                case 1:
                    addNewVehicle();
                    // add new Vehicle
                    break;
                case 2:
                    showVehicle();
                    // show Vehicle;
                    break;
                case 3:
                    deleteVehicle();
                    // delete a vehicle
                    break;
                case 0:
                    System.exit(choiceMenu);
                    // exit
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }
        }

    }

    private static void addNewVehicle() {
        boolean flagAddVehi = true;
        do {
            System.out.println("\n" +
                    "1. Add New Truck\n" +
                    "2. Add New Car\n" +
                    "3. Add New Motorcycle\n" +
                    "4. Back\n" +
                    "5. Exit\n");
            int choiceAddVehicle;
            System.out.print("Your choice is : ");
            choiceAddVehicle = Integer.parseInt(scanner.nextLine());
            switch (choiceAddVehicle) {
                case 1:
                    addVehicle(TRUCK);
                    break;
                case 2:
                    addVehicle(CAR);
                    break;
                case 3:
                    addVehicle(MOTORCYCLE);
                    break;
                case 4:
                    flagAddVehi = false;
                    break;
                case 5:
                    System.exit(choiceAddVehicle);
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }
        } while (flagAddVehi);
    }

    private static void addVehicle(int vehicleType) {
        String idVehicle;
        String manufacture;
        String yearManu;
        String owner;
        int numSeat;
        String typeCar;
        double payload;
        int wattage;

        System.out.print("Enter Id : ");
        idVehicle = scanner.nextLine();

        System.out.print("Enter Manufacture : ");
        manufacture = scanner.nextLine();
        // cho nhap truoc da
        System.out.print("Enter Year of Manufacture : ");
        yearManu = scanner.nextLine();
        System.out.print("Owner by : ");
        owner = scanner.nextLine();

        switch (vehicleType) {
            case CAR:
                System.out.print("Enter number of Seat : ");
                numSeat = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter type of Car : ");
                typeCar = scanner.nextLine();

                Car car = new Car(idVehicle,manufacture,yearManu,owner,numSeat,typeCar);
                carManagement.add(car);
                //
                break;
            case TRUCK:
                System.out.print("Enter payload of Truck : ");
                payload = Double.parseDouble(scanner.nextLine());

                Truck truck = new Truck(idVehicle,manufacture,yearManu,owner,payload);
                truckManagement.add(truck);
                //
                break;
            case MOTORCYCLE:
                System.out.print("Enter the Wattage : ");
                wattage = Integer.parseInt(scanner.nextLine());

                Motorcycle motorcycle = new Motorcycle(idVehicle,manufacture,yearManu,owner,wattage);
                motorcycleManagement.add(motorcycle);
                //
                break;
            case 4:
                break;
            default:
                break;
        }
    }

    private static void showVehicle() {
        boolean flagShow = true;
        do {
            System.out.println( "\n"+
                    "1. Display Truck\n"+
                    "2. Display Car\n"+
                    "3. Display Motorcycle\n"+
                    "4. Back\n"+
                    "5. Exit\n");
            int choiceShow;
            System.out.print("Your choice is : ");
            choiceShow = Integer.parseInt(scanner.nextLine());
            switch (choiceShow) {
                case 1:
                    showVehi(TRUCK);
                    break;
                case 2:
                    showVehi(CAR);
                    break;
                case 3:
                    showVehi(MOTORCYCLE);
                    break;
                case 4:
                    flagShow = false;
                    break;
                case 5:
                    System.exit(choiceShow);
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }
        }while (flagShow);
    }

    private static void showVehi(int typeVehicle) {
        switch (typeVehicle) {
            case TRUCK:
                List<Truck> listTruck = truckManagement.findAll();
                int i = 1;
                for(Truck truck : listTruck) {
                    System.out.println(i+". "+truck.showInfor());
                    i++;
                }
                break;
            case CAR:
                List<Car> listCar = carManagement.findAll();
                int j = 1;
                for(Car car : listCar) {
                    System.out.println(j+". "+car.showInfor());
                    j++;
                }
                break;
            case MOTORCYCLE:
                List<Motorcycle> listMotor = motorcycleManagement.findAll();
                int k = 1;
                for(Motorcycle motorcycle : listMotor) {
                    System.out.println(k+". "+motorcycle.showInfor());
                    k++;
                }
                break;
        }
    }

    private static void deleteVehicle() {
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
