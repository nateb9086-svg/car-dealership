package pluralsight.com;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return dealership;

    }
    public void saveDealership(){}

}


