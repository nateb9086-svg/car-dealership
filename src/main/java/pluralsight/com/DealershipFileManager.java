package pluralsight.com;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public void getDealership(){
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void saveDealership(){}

}


