package ru.student;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Helper {
    private static final Random rand = new Random();

    public static int[] createArr(int len, int maxValue) {
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

    public static ArrayList<Integer> createList(int len, int maxValue) {
        ArrayList<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            list.add(rand.nextInt(maxValue));
        }
        return list;
    }
}
