package ru.student;

public class Task1 {
    public static void runTask() {
        int testNumber = 5;

        System.out.printf("Треугольное чиcло = %d\n", triangularNumber(testNumber));

        int result = factorial(testNumber);
        System.out.printf("Факториал числа %d = %d\n", testNumber, result);
    }

    private static int triangularNumber(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++)
            count += i;
        return count;
    }

    private static int factorial(int num) {
        if (num == 1)
            return 1;
        return num * factorial(num - 1);
    }
}
