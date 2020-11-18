package Util;

import Model.Division;
import Model.Human;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomCSVParser {

    private static final Integer ID_INDEX = 0;
    private static final Integer NAME_INDEX = 1;
    private static final Integer GENDER_INDEX = 2;
    private static final Integer BIRTH_INDEX = 3;
    private static final Integer DIVISION_INDEX = 4;
    private static final Integer SALARY_INDEX = 5;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static List<Human> parseHumansByFilePath(String filePath) {
        List<Human> humans = new ArrayList<>();
        Map<String, Division> divisionByName = new HashMap<>();
        List<String[]> csvLines = CustomCSVReader.readCSVFromPath(filePath);
        csvLines.stream().map(CustomCSVParser::stringArrayToString).map(line -> line.split(";")).forEach(splitLine -> {
            Human human = new Human();
            human.setId(Long.parseLong(splitLine[ID_INDEX]));
            human.setName(splitLine[NAME_INDEX]);
            human.setGender(splitLine[GENDER_INDEX]);
            human.setBirtDate(LocalDate.parse(splitLine[BIRTH_INDEX], dateTimeFormatter));
            human.setSalary(Integer.parseInt(splitLine[SALARY_INDEX]));
            if (divisionByName.containsKey(splitLine[DIVISION_INDEX])) {
                human.setDivision(divisionByName.get(splitLine[DIVISION_INDEX]));
            } else {
                Division division = new Division(splitLine[DIVISION_INDEX]);
                divisionByName.put(splitLine[DIVISION_INDEX], division);
                human.setDivision(division);
            }
            humans.add(human);
        });
        return humans;
    }

    private static String stringArrayToString(String[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
