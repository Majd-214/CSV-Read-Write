import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVWriter {
    public static String headers;
    public static List<List<Double>> dataLines = new ArrayList<>();
    String filePath = new String();
    String directory = new String();

    public CSVWriter(String root){
        directory = root;
    }
    
    public void setFileName(String fileName) {
        this.filePath = directory + fileName + ".csv";
    }

    public void setHeader(String inputHeaders){
        headers = inputHeaders;
    }

    public void importData(List<List<Double>> data) {
        dataLines = data;
    }
    
    public void output() throws IOException {
        
        File csvOutputFile = new File(this.filePath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.println(headers);
            dataLines.stream().map(this::convertToCSV).forEach(pw::println);
        } catch (Exception e) {
            return;
        }
        if (!csvOutputFile.exists()) System.err.println("Failed!");
    }

    private String convertToCSV(List<Double> data) {
        String input = data.toString().replace("[", "").replace("]", "").trim();
        return Stream.of(input).collect(Collectors.joining(",")).replace(" ", "");
    }
}

