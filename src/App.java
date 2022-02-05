import java.util.ArrayList;
import java.util.List;

public class App {

    static List<List<Double>> data = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        data = CSVReader.convertToArrayList("/Users/Majdp/Desktop/test.csv");
        long startTime = System.currentTimeMillis();
        long currentTime;
        for (int i = 0; i < data.size(); i++) {
            do {
                currentTime = System.currentTimeMillis()-startTime;
            }while(currentTime < data.get(i).get(0).longValue());
            
            System.out.printf("%s | %s,%s\n",currentTime,data.get(i).get(0).longValue(),data.get(i).get(1));
        }
    }
        
}
