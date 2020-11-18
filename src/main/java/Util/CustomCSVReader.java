package Util;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CustomCSVReader {

    public static List<String[]> readCSVFromPath(String filePath) {
        List<String[]> response = new ArrayList<>();
        try {
            ClassLoader classLoader = CustomCSVReader.class.getClassLoader();
            File file = new File(classLoader.getResource(filePath).getFile());
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            response = csvReader.readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
