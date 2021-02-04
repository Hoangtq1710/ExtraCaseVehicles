package controllers;

import commons.exception.NotFoundVehicleException;
import commons.validation.vehicle_validation.*;
import models.*;
import services.CarManagement;
import services.ManuManagement;
import services.MotorcycleManagement;
import services.TruckManagement;

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
    static ManuManagement manuManagement = new ManuManagement();

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
        List<Manufacture> manuList = manuManagement.findAll();

        String idVehicle;
        String manufacture;
        String yearManu;
        String owner;
        int numSeat;
        String typeCar;
        double payload;
        int wattage;

        do {
            switch (vehicleType) {
                case TRUCK:
                    System.out.print("Enter Id (XXC-XXX.XX) : ");
                    break;
                case CAR:
                    System.out.print("Enter Id (XXY-XXX.XX) : ");
                    break;
                case MOTORCYCLE:
                    System.out.print("Enter Id (XX-YZ-XXX.XX) : ");
                    break;
            }
            System.out.print("Enter Id : ");
            idVehicle = scanner.nextLine();
            if (!IdVehicleValidation.IdVehicleValidate(vehicleType, idVehicle)) {
                System.out.println("Invalid ID");
            }
        } while (!IdVehicleValidation.IdVehicleValidate(vehicleType, idVehicle));
        System.out.println("--LIST OF MANUFACTURE--");
        int choiceManu;
        manuManagement.showManu(manuList); // display list of manufacture from csv

        do {
            System.out.print("Choose a Manufacture : ");
            choiceManu = Integer.parseInt(scanner.nextLine());
            if (choiceManu < 1 || choiceManu > manuList.size()) {
                System.out.println("Invalid Manufacture");
            }
        } while (choiceManu < 1 || choiceManu > manuList.size());
        manufacture = manuList.get(choiceManu - 1).toString(); // ghi vao file bang toString()

        do {
            System.out.print("Enter Year of Manufacture (1900-2020) : ");
            yearManu = scanner.nextLine();
            if (!YearManuValidation.yearValidate(yearManu)) {
                System.out.println("Invalid Year");
            }
        } while (!YearManuValidation.yearValidate(yearManu));
        System.out.print("Owner by : ");
        owner = scanner.nextLine();

        switch (vehicleType) {
            case CAR:
                do {
                    System.out.print("Enter number of Seat (1-19) : ");
                    numSeat = Integer.parseInt(scanner.nextLine());
                    if (!NumSeatValidation.numSeatValidate(numSeat)) {
                        System.out.println("Number of Seat Invalid");
                    }
                } while (!NumSeatValidation.numSeatValidate(numSeat));

                typeCar = ((idVehicle.charAt(3) == 'A') ? "Tourist car" : "Coach");

                Car car = new Car(idVehicle, manufacture, yearManu, owner, numSeat, typeCar);
                carManagement.add(car);
                //
                break;
            case TRUCK:
                do {
                    System.out.print("Enter payload of Truck ( > 0 T): ");
                    payload = Double.parseDouble(scanner.nextLine());
                    if (!PayloadValidation.payloadValidate(payload)) {
                        System.out.println("Invalid Payload");
                    }
                } while (!PayloadValidation.payloadValidate(payload));

                Truck truck = new Truck(idVehicle, manufacture, yearManu, owner, payload);
                truckManagement.add(truck);
                //
                break;
            case MOTORCYCLE:
                do {
                    System.out.print("Enter the Wattage (0 < W < 500) : ");
                    wattage = Integer.parseInt(scanner.nextLine());
                    if (!WattageValidation.wattageValidate(wattage)) {
                        System.out.println("Invalid Wattage");
                    }
                } while (!WattageValidation.wattageValidate(wattage));

                Motorcycle motorcycle = new Motorcycle(idVehicle, manufacture, yearManu, owner, wattage);
                motorcycleManagement.add(motorcycle);
                //
                break;
            default:
                System.out.println("IMPOSSIBLE");
                break;
        }
    }

    private static void showVehicle() {
        boolean flagShow = true;
        do {
            System.out.println("\n" +
                    "1. Display Truck\n" +
                    "2. Display Car\n" +
                    "3. Display Motorcycle\n" +
                    "4. Back\n" +
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
        } while (flagShow);
    }

    private static void showVehi(int typeVehicle) {
        switch (typeVehicle) {
            case TRUCK:
                List<Truck> listTruck = truckManagement.findAll();
                int i = 1;
                for (Truck truck : listTruck) {
                    System.out.println(i + ". " + truck.showInfor());
                    i++;
                }
                break;
            case CAR:
                List<Car> listCar = carManagement.findAll();
                int j = 1;
                for (Car car : listCar) {
                    System.out.println(j + ". " + car.showInfor());
                    j++;
                }
                break;
            case MOTORCYCLE:
                List<Motorcycle> listMotor = motorcycleManagement.findAll();
                int k = 1;
                for (Motorcycle motorcycle : listMotor) {
                    System.out.println(k + ". " + motorcycle.showInfor());
                    k++;
                }
                break;
        }
    }

    private static void deleteVehicle() {
        System.out.print("Enter a ID Vehicle you wanna delete : ");
        String idDelete = scanner.nextLine();
        try {
            if (checkIdToDelete(idDelete) != null) {
                int choiceDelete;
                System.out.print("ARE YOU SURE?\t\t1. YES\t|\t2. NO\t: ");
                choiceDelete = Integer.parseInt(scanner.nextLine());
                switch (choiceDelete) {
                    case 1:
                        deleteID(idDelete);
                        break;
                    case 2:
                        //back to main menu
                        break;
                    default:
                        System.out.println("Failed");
                        break;
                }
            } else {
                throw new NotFoundVehicleException("ID Vehicle NOT found!");
            }
        } catch (NotFoundVehicleException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteID(String idDelete) {
        List<Truck> listTruck = truckManagement.findAll();
        List<Car> listCar = carManagement.findAll();
        List<Motorcycle> listMoto = motorcycleManagement.findAll();
        boolean flagDelete = true;

        for (Truck truck : listTruck) {
            if (truck.getIdVehicle().equals(idDelete)) {
                listTruck.remove(truck);
                truckManagement.addAll(listTruck);
                flagDelete = false;
                break;
                //
            }
        }
        for (Car car : listCar) {
            if (car.getIdVehicle().equals(idDelete)) {
                listCar.remove(car);
                carManagement.addAll(listCar);
                flagDelete = false;
                break;
                //
            }
        }
        for (Motorcycle motorcycle : listMoto) {
            if (motorcycle.getIdVehicle().equals(idDelete)) {
                listMoto.remove(motorcycle);
                motorcycleManagement.addAll(listMoto);
                flagDelete = false;
                break;
                //
            }
        }
        if (!flagDelete) {
            System.out.println("Successfully delete ID " + idDelete);
        }
    }

    private static Vehicles checkIdToDelete(String id) {
        List<Truck> listTruck = truckManagement.findAll();
        List<Car> listCar = carManagement.findAll();
        List<Motorcycle> listMoto = motorcycleManagement.findAll();

        for (Truck truck : listTruck) {
            if (truck.getIdVehicle().equals(id)) {
                return truck;
            }
        }
        for (Car car : listCar) {
            if (car.getIdVehicle().equals(id)) {
                return car;
            }
        }
        for (Motorcycle motorcycle : listMoto) {
            if (motorcycle.getIdVehicle().equals(id)) {
                return motorcycle;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
