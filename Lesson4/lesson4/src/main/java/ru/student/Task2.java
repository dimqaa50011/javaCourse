package ru.student;

import java.util.LinkedList;
import java.util.List;

// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

public class Task2 {
    private List<Integer> numbers = new LinkedList<>();

    public void enqueue(int element){
        numbers.add(element);
    }
    public int dequeue(){
        if (numbers.isEmpty()){
            System.out.println("Очередь пуста. Сначала ее нужно наполнить");
            return -1;
        }
        int element = numbers.get(0);
        numbers.remove(0);
        return element;
    }
    public int first(){
        if (numbers.isEmpty()){
            System.out.println("Очередь пуста. Сначала ее нужно наполнить");
            return -1;
        }
        return numbers.get(0);
    }
    public String toCustomStrig() {
        return numbers.toString();
    }
}
