package ru.student;

public class Task2 {
    public static void runTask() {
        primeNumbers(1000);
    }

    private static void primeNumbers(int maxNum) {
        for (int i = 2; i < maxNum + 1; i++) {
            if (checkPrime(i, maxNum))
                System.out.printf("%d ", i);
        }
        System.out.println();
    }

    private static boolean checkPrime(int num, int maxNum) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
