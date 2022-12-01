package ru.student;

import java.util.ArrayList;

public class Task3 {
    // Задан целочисленный список ArrayList.
    // Найти минимальное, максимальное и среднее арифметичское этого списка
    private static final int indexMax = 0;
    private static final int indexMin = 1;

    public static void run() {
        ArrayList<Integer> list = Helper.createList(Helper.inputArg("Введите длину списка"),
                Helper.inputArg("Введите максиматьное значение элемента списка"));
        System.out.printf("Исходный список %s\n", list);
        int[] extremeValues = getExtremeValueList(list);
        double avrVal = avarage(list);
        System.out.printf("Максимум: %d\nМинимум: %d\nСреднее арифметическое: %.2f\n", extremeValues[indexMax],
                extremeValues[indexMin], avrVal);

    }

    private static int[] getExtremeValueList(ArrayList<Integer> list) {
        int maxValue = list.get(0);
        int minValue = list.get(0);
        for (int item : list) {
            if (item > maxValue)
                maxValue = item;
            if (item < minValue)
                minValue = item;
        }
        return new int[] { maxValue, minValue };
    }

    private static double avarage(ArrayList<Integer> list) {
        double count = 0;
        for (int item : list)
            count += item;
        return count / list.size();
    }
}
