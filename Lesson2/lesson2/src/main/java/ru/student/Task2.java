package ru.student;

import java.lang.reflect.Array;
import java.util.Random;

public class Task2 {
    public static void run() {
        int[] arr = createArray(15, 20);
        System.out.println(arr);
        
    }
    private static int[] createArray(int len, int maxValueElement) {
        Random rand = new Random();
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(maxValueElement);
        }
        return arr;
    }
}
