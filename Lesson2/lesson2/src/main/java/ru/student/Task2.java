package ru.student;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.

public class Task2 {
    private static String logFile = "task2LogFile.log";
    private static Logger logger;

    public static void run() {
        createLogger(Task2.class.getName());
        int[] arr = createArray(15, 20);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static int[] createArray(int len, int maxValueElement) {
        Random rand = new Random();
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(maxValueElement);
        }
        return arr;
    }
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    logger.info(Arrays.toString(arr));
                }
            }
        }
    }

    private static void createLogger(String className) {
        logger = Logger.getLogger(className);
        try {
            FileHandler handler = new FileHandler(logFile);
            logger.addHandler(handler);
            SimpleFormatter sf = new SimpleFormatter();
            handler.setFormatter(sf);
        } catch (IOException e) {
            System.out.println("Не удалось создалт логгер");
        }
    }

}
