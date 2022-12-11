package ru.student;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void run() {
        int[] numbers = createArray(15);
        System.out.println(Arrays.toString(numbers));
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static int[] createArray(int len) {
        int[] arr = new int[len];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50);
        }

        return arr;
    }

    private static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);

        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }

    }

    private static void heapify(int[] arr, int n, int i) {
        int indexRootElement = i;
        int indexLeftChild = 2 * i + 1;
        int indexRightChild = 2 * i + 2;

        if (indexLeftChild < n && arr[indexLeftChild] > arr[indexRootElement])
            indexRootElement = indexLeftChild;
        if (indexRightChild < n && arr[indexRightChild] > arr[indexRootElement])
            indexRootElement = indexRightChild;
        if (indexRootElement != i) {
            int temp = arr[i];
            arr[i] = arr[indexRootElement];
            arr[indexRootElement] = temp;

            heapify(arr, n, indexRootElement);
        }
    }
}
