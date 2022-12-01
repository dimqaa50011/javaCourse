package ru.student;

import java.util.Arrays;

public class Task1 {
    public static void run() {
        // Реализовать алгоритм сортировки слиянием.

        
        int[] arr = Helper.createArr(Helper.inputArg("Введите длину массива"),
                Helper.inputArg("Введите максимально значение элемента массива"));

        System.out.printf("Исходный массив:\t%s\n", Arrays.toString(arr));
        mergeSort(arr);
        System.out.printf("Отсортированный массив:\t%s\n", Arrays.toString(arr));
    }

    private static void mergeToArr(int[] src, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
            src[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
        while (i < left.length)
            src[k++] = left[i++];
        while (j < right.length)
            src[k++] = right[j++];

    }

    private static void mergeSort(int[] arr) {
        if (arr.length == 1)
            return;
        int middle = arr.length / 2;
        int[] left = new int[middle];
        int[] right = new int[arr.length - middle];

        System.arraycopy(arr, 0, left, 0, middle);
        System.arraycopy(arr, middle, right, 0, arr.length - middle);

        mergeSort(left);
        mergeSort(right);

        mergeToArr(arr, left, right);
    }
}
