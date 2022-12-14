package ru.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// Пусть дан список сотрудников: Иван, Пётр, Антон и так далее.
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности

public class RepeatName {
    private static Map<String, Integer> repeatUsernames = new HashMap<>();

    public static void run() {
        List<String> usernames = Arrays.asList(
                "Мария",
                "Иван",
                "Ирина",
                "Владимир",
                "Иван",
                "Виктория",
                "Мария",
                "Ирина",
                "Владимир",
                "Дмитрий",
                "Иван",
                "Ирина",
                "Виктория",
                "Ирина",
                "Владимир",
                "Мария",
                "Виктория",
                "Дмитрий",
                "Иван",
                "Виктория",
                "Мария",
                "Ирина",
                "Дмитрий",
                "Владимир",
                "Виктория",
                "Иван",
                "Мария",
                "Владимир",
                "Виктория",
                "Дмитрий",
                "Иван");

        getRepeatNames(usernames);

        System.out.println(repeatUsernames);
        System.out.println(sortRepeatNames());
    }

    private static void getRepeatNames(List<String> namesList) {
        for (String name : namesList) {
            if (repeatUsernames.containsKey(name)) {
                int countRepeat = repeatUsernames.get(name);
                countRepeat += 1;
                repeatUsernames.put(name, countRepeat);
            } else
                repeatUsernames.put(name, 1);
        }
    }

    private static List<Entry<String, Integer>> sortRepeatNames() {
        List<Entry<String, Integer>> res = new ArrayList<>(repeatUsernames.entrySet());
        Collections.sort(res, new Comparator<Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
                return arg1.getValue().compareTo(arg0.getValue());
            }

        });
        return res;
    }
}
