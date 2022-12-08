package ru.student;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

public class Task1 {
    public static void run() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите длину листа: ");
        int lenList = scan.nextInt();
        System.out.print("Введите максимальное значение элемента: ");
        int maxValue = scan.nextInt();
        scan.close();

        List<Integer> numbersList = Helper.createList(lenList, maxValue);
        System.out.printf("Исходный список: %s\n", numbersList);
        System.out.printf("Перевернутый: %s\n", reverseList(numbersList));
    }

    private static List<Integer> reverseList(List<Integer> numbers) {
        List<Integer> reverseNumbers = new LinkedList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            reverseNumbers.add(numbers.get(i));
        }
        return reverseNumbers;
    }
}
