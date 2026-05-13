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

    private void processGetByPriceRequest() {}
    private void processGetByMakeModelRequest() {}
    private void processGetByYearRequest() {}
    private void processGetByColorRequest() {}
    private void processGetByMileageRequest() {}
    private void processGetByVehicleTypeRequest() {}

    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }
    private void processAddVehicleRequest() {}
    private void processRemoveVehicleRequest() {}

}