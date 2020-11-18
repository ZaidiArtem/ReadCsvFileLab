import Model.Human;
import Util.CustomCSVParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "csv/foreign_names.csv";
        List<Human> humans = CustomCSVParser.parseHumansByFilePath(filePath);
        humans.forEach(human -> {
            System.out.println(human.toString());
        });
    }
}
