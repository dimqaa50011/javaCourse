package ru.student;

import java.util.ArrayList;

public class Task2 {
    // Пусть дан произвольный список целых чисел. Удалить из него чётные числа
    public static void run() {
        ArrayList<Integer> list = Helper.createList(Helper.inputArg("Введите длину списка"),
                Helper.inputArg("Введите максиматьное значение элемента списка"));
        System.out.println(list);
        deleteEvenElement(list);
        System.out.println(list);
    }

    private static void deleteEvenElement(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) % 2 == 0 || list.get(i) == 0) // ноль - это четная цифра
                list.remove(i);
    }
}
