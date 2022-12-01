package ru.student;

import java.util.Random;
import java.util.Scanner;

public class Helper {
    public static int[] createArr(int len, int maxValue) {
        Random rand = new Random();
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(maxValue);
        }
        return arr;
    }

    public static int inputArg(String msg) {
        System.out.printf("%s: ", msg);
        final Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
