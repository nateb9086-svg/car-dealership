package pluralsight.com;
import java.io.*;

public class DealershipFileManager {



    public Dealership getDealership(){
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;

            String headerLine = reader.readLine();
            if (headerLine != null) {
                String[] parts = headerLine.split("\\|");
                dealership = new Dealership(parts[0], parts[1], parts[2]);
            }
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                Vehicle v = new Vehicle(
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        parts[2], parts[3], parts[4], parts[5],
                        Integer.parseInt(parts[6]),
                        Double.parseDouble(parts[7])
                );
                dealership.addVehicle(v);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return dealership;

    }




    public void saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("inventory.csv"))) {
            writer.printf("%s|%s|%s%n",
                    dealership.getName(), dealership.getAddress(), dealership.getPhone());
            for (Vehicle v : dealership.getAllVehicles()) {
                writer.printf("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                        v.getVehicleType(), v.getColor(), v.getOdometor(), v.getPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


