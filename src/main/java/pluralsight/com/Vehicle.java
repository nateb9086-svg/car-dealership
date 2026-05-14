package pluralsight.com;

public class Vehicle {


    private int vin, year, odometor;
    private String make, model, vehicleType, color;
    private double price;

    public Vehicle(int vin, int year, String make, String model,
                   String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometor = odometer;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%d | %d | %-10s | %-10s | %-6s | %-8s | %7d mi | $%.2f",
                vin, year, make, model, vehicleType, color, odometor, price);
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometor() {
        return odometor;
    }

    public void setOdometor(int odometor) {
        this.odometor = odometor;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
