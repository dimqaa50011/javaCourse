package ru.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов

public class PhoneBook {
    private Map<String, List<Integer>> phoneBook = new HashMap<>();

    public void getAll() {
        String msg;
        if (phoneBook.isEmpty())
            msg = "Телефонная книга пуста. Сначала ее нужно наполнить";
        else
            msg = String.format("Пользователи в вашей телефонной книге:\n%s", phoneBook);
        System.out.println(msg);
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

    public void removeUser(String name) {
        String msg;
        if (deleteUser(name))
            msg = String.format("Пользователь %s удален", name);
        else
            msg = String.format("Пользователя %s несуществует", name);
        System.out.println(msg);
    }

    private boolean deleteUser(String name) {
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            return true;
        }
        return false;
    }

    public void removePhone(String name, int index) {
        String msg;
        int result = deletePhone(name, index);
        if (result != -1)
            msg = String.format("Телефон %d пользователя %s удален", result, name);
        else
            msg = String.format("Пользователя %s несуществует", name);
        System.out.println(msg);
    }

    private int deletePhone(String name, int index) {
        if (phoneBook.containsKey(name)) {
            List<Integer> userPhones = phoneBook.get(name);
            int phone = userPhones.get(index);
            userPhones.remove(index);
            phoneBook.put(name, userPhones);
            return phone;
        }
        return -1;
    }

}
