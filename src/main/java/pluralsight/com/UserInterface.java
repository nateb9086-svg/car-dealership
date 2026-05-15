package pluralsight.com;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void display() {
        init();
        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = getChoice();

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println(" 1. Search by Price");
        System.out.println(" 2. Search by Make / Model");
        System.out.println(" 3. Search by Year");
        System.out.println(" 4. Search by Color");
        System.out.println(" 5. Search by Mileage");
        System.out.println(" 6. Search by Vehicle Type");
        System.out.println(" 7. View All Vehicles");
        System.out.println(" 8. Add a Vehicle");
        System.out.println(" 9. Remove a Vehicle");
        System.out.println(" 0. Exit");
        System.out.println("Enter your choice by pushing and entering adjacent number: ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void processGetByPriceRequest() {
        System.out.print("Min price: ");
        double min = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Max price: ");
        double max = Double.parseDouble(scanner.nextLine().trim());
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }
    private void processGetByMakeModelRequest() {
        System.out.print("Make: ");
        String make = scanner.nextLine().trim();
        System.out.print("Model: ");
        String model = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }
    private void processGetByYearRequest() {
        System.out.print("Min year: ");
        int min = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Max year: ");
        int max = Integer.parseInt(scanner.nextLine().trim());
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }
    private void processGetByColorRequest() {
        System.out.print("Color: ");
        String color = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByColor(color));
    }
    private void processGetByMileageRequest() {
        System.out.print("Min mileage: ");
        int min = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Max mileage: ");
        int max = Integer.parseInt(scanner.nextLine().trim());
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }
    private void processGetByVehicleTypeRequest() {
        System.out.print("Vehicle type: ");
        String type = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }
    private void processAddVehicleRequest() {
        try {
            System.out.print("VIN: ");        int vin  = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Year: ");       int year = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Make: ");       String make  = scanner.nextLine().trim();
            System.out.print("Model: ");      String model = scanner.nextLine().trim();
            System.out.print("Type: ");       String type  = scanner.nextLine().trim();
            System.out.print("Color: ");      String color = scanner.nextLine().trim();
            System.out.print("Mileage: ");    int odo   = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Price: ");      double price = Double.parseDouble(scanner.nextLine().trim());

            dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, odo, price));
            new DealershipFileManager().saveDealership(dealership);
            System.out.println("Vehicle added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Vehicle is not added.");
        }
    }
    private void processRemoveVehicleRequest() {
        System.out.print("Enter VIN to remove: ");
        try {
            int vin = Integer.parseInt(scanner.nextLine().trim());
            dealership.removeVehicle(vin);
            new DealershipFileManager().saveDealership(dealership);
            System.out.println("Vehicle removed (if it existed).");
        } catch (NumberFormatException e) {
            System.out.println("Invalid VIN.");
        }
    }

}