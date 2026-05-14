package pluralsight.com;
import java.util.ArrayList;

public class Dealership {

    String name, address, phone;
    ArrayList<Vehicle> vehicles;


    public Dealership( String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles)
            if (v.getPrice() >= min && v.getPrice() <= max) result.add(v);
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles)
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model))
                result.add(v);
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles)
            if (v.getYear() >= min && v.getYear() <= max) result.add(v);
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles)
            if (v.getColor().equalsIgnoreCase(color)) result.add(v);
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles)
            if (v.getOdometor() >= min && v.getOdometor() <= max) result.add(v);
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles)
            if (v.getVehicleType().equalsIgnoreCase(type)) result.add(v);
        return result;
    }
    public void removeVehicle(int vin) {
        vehicles.removeIf(v -> v.getVin() == vin);
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }


}
