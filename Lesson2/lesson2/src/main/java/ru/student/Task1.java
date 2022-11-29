package ru.student;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// В файле содержится строка с исходными данными в такой форме:
//  {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";

// Для разбора строки используйте String.split. Сформируйте новую строку, 
// используя StringBuilder. Значения null не включаются в запрос.

public class Task1 {
    private static String baseQuery = "SELECT * FROM students WHERE ";
    private static final String logFile = "logFile.log";
    private static ArrayList<String> paramsQuery = new ArrayList<>();

    public static void run() {
        File file = new File("forTask1.txt");
        System.out.println(parseJSONText(parseFile(file.getAbsolutePath())));
    }

    private static String parseFile(String pathToFile) {
        String exceptionResult = "0";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            return reader.readLine();
        } catch (IOException e) {
            logMessage(e.getMessage());
            return exceptionResult;
        }
    }

    private static String parseJSONText(String jsonText) {
        jsonText = jsonText.replaceAll("\\{|\\}", "");
        String[] keyValueArr = jsonText.split(", ");
        StringBuilder sb = new StringBuilder();
        sb.append(baseQuery);
        for (int i = 0; i < keyValueArr.length; i++) {
            String[] params = getKeyAndValue(keyValueArr[i]);
            if (!params[params.length - 1].equals("\"null\""))
                paramsQuery.add(String.join("=", params));
        }
        sb.append(String.join(" ", paramsQuery));
        sb.append(";");
        return sb.toString();

    }

    private static String[] getKeyAndValue(String keyValueStr) {
        String[] parametrs = keyValueStr.split(":");
        parametrs[0] = parametrs[0].replaceAll("\"", "");
        return parametrs;
    }

    private static Logger logging() throws IOException {
        Logger logger = Logger.getLogger(Task1.class.getName());
        FileHandler handler = new FileHandler(logFile);
        logger.addHandler(handler);
        SimpleFormatter sf = new SimpleFormatter();
        handler.setFormatter(sf);
        return logger;
    }

    private static void logMessage(String msg) {
        try {
            Logger logger = logging();
            logger.severe(msg);
        } catch (IOException e) {
            System.out.println("Не удалось создать логгер");
        }
    }
}
