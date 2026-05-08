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

    public void getVehiclesByPrice(){}
    public void getVehiclesByMakeModel() {}
    public void getVehiclesByYear(){}
    public void getVehiclesByColor(){}
    public void getVehiclesByMileage(){}
    public void getVehiclesByType(){}
    public void removeVehicle(){}

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }


}
