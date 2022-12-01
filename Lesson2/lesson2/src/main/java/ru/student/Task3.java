package ru.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// В файле содержится строка с данными:

// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

// Напишите метод, который разберёт её на составные части и, используя
// StringBuilder создаст массив строк такого вида:

// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

public class Task3 {
    private static String sourceFile;
    private static String[] constStrElements = { "Студент", "получил", "по предмету" };
    public static void run() {
        File file = new File("lesson2", "forTask3.txt");
        parseFile(file.getAbsolutePath());
        System.out.println(processParsedJSON());
    }
    private static void parseFile(String pathToFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            sourceFile = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static String processParsedJSON() {
        StringBuilder sb = new StringBuilder();
        String[] objArr = cleanString(sourceFile, "\\[|\\]").split(", ");
        for (int i = 0; i < objArr.length; i++) {
            objArr[i] = cleanString(objArr[i], "\\{|\\}");
            sb.append(createCard(objArr[i]));
            sb.append("\n");
        }
        return sb.toString();
    }
    private static String cleanString(String str, String symbol) {
        return str.replaceAll(symbol, "");
    }
    private static String createCard(String oneObj) {
        StringBuilder sb = new StringBuilder();
        String[] data = oneObj.split(",");
        for (int i = 0; i < data.length; i++) {
            String[] temp = data[i].split(":");
            sb.append(constStrElements[i]);
            sb.append(" ");
            sb.append(cleanString(temp[temp.length - 1], "\""));
            sb.append(" ");
        }
        return sb.toString();
    } 
}
