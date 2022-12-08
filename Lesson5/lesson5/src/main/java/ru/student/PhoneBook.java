package ru.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов

public class PhoneBook {
    private Map<String, List<Integer>> phoneBook = new HashMap<>();

    public Map<String, List<Integer>> getAll() {
        return phoneBook;
    }

    public List<Integer> getOneUser(String name) {
        if (phoneBook.containsKey(name))
            return phoneBook.get(name);
        System.out.println("Такого пользователя не существует");
        List<Integer> gag = new ArrayList<>();
        return gag;
    }

    public void addNewContact(String name, int... phones) {
        phoneBook.put(name, convertToList(phones));
    }

    public void addNewPhone(String name, int phone) {
        if (phoneBook.containsKey(name)) {
            List<Integer> userBoundPhons = phoneBook.get(name);
            userBoundPhons.add(phone);
            phoneBook.put(name, userBoundPhons);
        } else
            addNewContact(name, phone);
    }

    private List<Integer> convertToList(int[] phones) {
        List<Integer> phonesList = new ArrayList<>();
        for (int phone : phones) {
            phonesList.add(phone);
        }
        return phonesList;
    }

}
