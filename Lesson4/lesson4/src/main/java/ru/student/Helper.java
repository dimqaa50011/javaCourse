package ru.student;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Helper {
    public static List<Integer> createList(int len, int maxValue) {
        Random rand = new Random();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            list.add(rand.nextInt(maxValue));
        }
        return list;
    }

    public static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
