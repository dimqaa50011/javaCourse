package ru.student;

import java.util.Arrays;

public class Task1 {
    public static void runTask() {
        int testNumber = 5;
        int[] numbers = triangularNumber(testNumber);
        System.out.println(Arrays.toString(numbers));
        int result = factorial(testNumber);
        System.out.printf("Факториал числа %d = %d\n", testNumber, result);
    }


    private static int[] triangularNumber(int number) {
        int[] numbers = new int[number];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = getOneTriangularNumber(i + 1);
        return numbers;
    }

    private static int getOneTriangularNumber(int border) {
        int count = 0;
        for (int j = 1; j <= border; j++)
            count += j;
        return count;
    }

    private static int factorial(int num) {
        if (num == 1)
            return 1;
        return num * factorial(num - 1);
    }
}
